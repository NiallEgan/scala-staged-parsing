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

This is then compiled to this [recursive descent parser ](./src/test/scala/generatedPrograms/acbEprogram.scala).

## Syntax
The syntax is largely similar to the standard Scala parser combinator library with some differences.


| Symbol  | Type      | Description  |
| ------- | --------- | ------------ |
| ``~ ``  | right-ali | $1600        |
| ``<|>`` | centered  |   $12        |
| ``??``  | are neat  |    $1        |
| ``**``  | are neat  |    $1        |
| ``^^``  | are neat  |    $1        |
| ``'a'`` | are neat  |    $1        |
| ``eps`` |           |              |
| ``fix`` |           |              |
