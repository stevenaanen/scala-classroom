
abstract class IntSet {
  def inc(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}
object Empty extends IntSet {
  def inc(x: Int) = new NonEmpty(x, Empty, Empty)
  def contains(x: Int) = false
  def union(other: IntSet) = other
  override def toString = "."
}
class NonEmpty(value: Int, leftNode: IntSet, rightNode: IntSet) extends IntSet {
  def inc(x: Int) =
    if (x < value) new NonEmpty(value, leftNode inc x, rightNode)
    else if (x > value) new NonEmpty(value, leftNode, rightNode inc x)
    else this
  def contains(x: Int) =
    if (x < value) leftNode contains x
    else if (x > value) rightNode contains x
    else true
  def union(other: IntSet) =
    if (other.value < value)

  override def toString = s"{$leftNode$value$rightNode}"
}

val t1: IntSet = Empty
val t2: IntSet = t1.inc(3)
t2 inc 5 inc 2 inc 1 inc 4