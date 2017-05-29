abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat

  override def toString =
    if (isZero) "0"
    else "1+" + predecessor.toString
}

object Zero extends Nat {
  def isZero: Boolean = true

  def successor: Nat = new NonZero(Zero)

  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = throw new IllegalStateException("cannot substract from zero")

  def predecessor: Nat = throw new IllegalAccessException("zero has no predecessor")
}

class NonZero(val predecessor: Nat) extends Nat {
  def isZero: Boolean = false

  def successor: Nat = new NonZero(this)

  def +(that: Nat): Nat = ???

  def -(that: Nat): Nat = ???
}

Zero.successor.successor.successor.predecessor.isZero
