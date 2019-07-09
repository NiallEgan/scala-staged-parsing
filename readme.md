
# ssp - safe, staged parsing

A **typed** parser combinator library that is **staged** for extra efficiency.
A Scala port of [ocaml-asp](https://www.cl.cam.ac.uk/~jdy22/papers/a-typed-algebraic-approach-to-parsing.pdf) which was developed by Jeremy Yallop and Neel Krishnaswami.

## Why typed?
The [type system for parsers](https://www.cl.cam.ac.uk/~jdy22/papers/a-typed-algebraic-approach-to-parsing.pdf) ensures that all well-typed parsers are guaranteed to run in linear time. This is done by only typing grammars which are amenable to recursive descent and as such require no backtracking. The result is that parsers have much more predictable and reliable performance.

## Why staged?
The library leverages the [*lightweight modular staging*](http://scala-lms.github.io/) library to generate / compile specialised lower-level Scala programs from more general abstract ones. This means that all interpretive overhead is removed, resulting in a recursive descent parser that is just as fast as if you had written it by hand, while still being able to write the high-level description using combinators.

## Examples
An extremely simple (non-recursive) parser can be expressed using the combinators as ``'a' ~ ('b' <|> 'c')``. This is then compiled to [this recursive descent parser](./src/test/scala/generatedPrograms/compoundPrograms1.scala).
Recursion is expressed through the use of fix-point operators in the style of mu-regular expressions.
For example, the grammar ``E ::= ac | bE `` expressed in terms of parser combinators is:
```
 fix (e => {
      val ac ='a' ~ 'c'
      val left = ac ^^ pair2list
      val right = ('b' ~ e) ^^ cons
      left <|> right
 })
```

This is then compiled to this [recursive descent parser](./src/test/scala/generatedPrograms/acbEprogram.scala).

## Syntax
The syntax is largely similar to the standard Scala parser combinator library with some differences.


| Symbol  | Type        | Description  |
| ------- | ---------   | ------------ |
| ``~ ``  | ``Parser[T] -> Parser[U] -> Parser[(T, U)]`` | Concatenation        |
| ``<>`` | ``Parser[T] -> Parser[T] -> Parser[T]``  |   Alternation       |
| ``??``  | ``Parser[T] -> Parser[\/[Unit, T]]``  |    Option (0 or 1)        |
| ``**``  | ``Parser[T] -> Parser[List[T]]`` |    Kleene Star (0 or more)        |
| ``^^``  | ``Parser[T] -> (Rep[T] -> Rep[U]) -> Parser[U]``  |   (Staged) Map        |
| ``'a'`` | ``Parser[Char]``  |    Character parser for character 'a'        |
| ``eps`` | ``Parser[Unit]``        |  Matches the empty string            |
| ``fix`` | ``(Parser[T] -> Parser[T]) -> Parser[T]``          |      Least fixed point (for recursion)        |
