This is the code written as part of the talk introducing Type Classes in Scala that I gave at 
[Scala Exchange 2015](https://skillsmatter.com/conferences/6862-scala-exchange-2015#program).

There's a video available [on the Skills Matter site](https://skillsmatter.com/skillscasts/6832-what-are-typeclasses-and-why-you-should-care) 

[inheritance.sc](inheritance.sc) attempts to show how you might try and deal with serialisation 
to and from [DynamoDB](https://aws.amazon.com/dynamodb). You don't need to know anything about
DynamoDB except for the fact that it can represent all the types it accepts as an `AttributeValue`.

[type class.sc](type%20class.sc) does the same job, but with a type class, showing how it more 
elegantly constructs the type and facilitates composition of type class instances.

[combine.sc](combine.sc) shows an example of using type classes for something other than 
serialisation, in this case combining together multiple objects of the same type into a single 
instance. 

This is fleshed out more in [SemiGroup.scala](src/main/scala/scalaexchange/SemiGroup.scala]
which also makes us of [Simulacrum](https://github.com/mpilquist/simulacrum). If SemiGroup has 
peeked your interest then you should look at a real instance, such as that in [algebra](https://github.com/non/algebra/blob/master/core/src/main/scala/algebra/Semigroup.scala),
which you can find some documentation for [here](http://non.github.io/cats//tut/semigroup.html).