package steves.scala

abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean): Boolean = ifThenElse(x, false)
  def || (x: => Boolean): Boolean = ifThenElse(true, x)
  def unary_!: Boolean = ifThenElse(false, true)

  def < (x: => Boolean): Boolean = ifThenElse(false, x)
}

object false extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = e
}
object true extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = t
}

true && false
false && true
false && false

true || false
true.unary_!