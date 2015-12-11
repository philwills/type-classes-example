package scalaexchange

import simulacrum.typeclass

@typeclass trait SemiGroup[T] {
  def combine(a: T, b: T): T
}

object SemiGroup {

  implicit object IntAddition extends SemiGroup[Int] {
    override def combine(a: Int, b: Int) = a + b
  }

  implicit def optionSemiGroup[T](implicit sg: SemiGroup[T]) =
    new SemiGroup[Option[T]] {
      override def combine(a: Option[T], b: Option[T]) =
        a match {
          case None => b
          case Some(x) =>
            b match {
              case None => a
              case Some(y) => Some(sg.combine(x, y))
            }
        }
    }
}