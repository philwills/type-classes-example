package scalaexchange

case class Foo(bar: Option[Int])

object Foo {

  implicit object FooSemiGroup extends SemiGroup[Foo] {
    implicit object MaxIntSemiGroup
      extends SemiGroup[Int] {
      override def combine(a: Int, b: Int) =
        Math.max(a, b)
    }

    override def combine(a: Foo, b: Foo) = {
      import SemiGroup.ops._

      Foo(a.bar combine b.bar)
    }
  }
}
