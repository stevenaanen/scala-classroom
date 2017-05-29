trait List[T] {
  def head: T
  def tail: List[T]
  def isEmpty: Boolean
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.head")
  def isEmpty = true
  override def toString = "Nil"
}

def nth[T](n: Int, list: List[T]): T = {
  def seek(k: Int, currentList: List[T]): T =
    try {
      if (k == n) currentList.head
      else seek(k + 1, currentList.tail)
    } catch {
      case e: NoSuchElementException => throw new Error("")
    }

  seek(0, list)
}

val l = new Cons[Int](2, new Cons(4, new Nil))
l.head
l.tail.tail
nth(2, l)