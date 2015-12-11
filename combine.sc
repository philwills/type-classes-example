trait Combinable[T] {
  def combine(a: T, b: T): T
}

object Combinable {
  def apply[T](implicit c: Combinable[T]) = c

  trait CombinableOps[T] {
    def self: T
    def combinable: Combinable[T]
    def combine(other: T) =
      combinable.combine(self, other)
  }
  object ops {
    implicit def toCombinalbeOps[T](t: T)(implicit c: Combinable[T]) ={
      new CombinableOps[T] {
        override def self = t
        override def combinable = c
      }
    }
  }

  implicit object StringCombinable
    extends Combinable[String] {
    override def combine(a: String, b: String) =
      a + b
  }
}

val combinable = Combinable[String]
combinable.combine("foo",
  combinable.combine("bar", "baz"))

import Combinable.ops._
"foo" combine "bar" combine "baz"











