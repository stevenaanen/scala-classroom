object List {
//  def apply = scala.collection.LinearSeq.empty
//  def apply[T](arg: T) = Array[T](arg)
//  def apply[T](arg0: T, arg1: T) = Array[T](arg0, arg1)
}

//List()
//List(1)
//List(2, 3)


(x: Int) => x * x

class Square extends Function1[Int, Int] {
  def apply(x: Int): Int = x * x
}
new Function1[Int, Int] {
  def apply(x: Int): Int = x * x
}

val value: Int = throw new Error("nothing")
