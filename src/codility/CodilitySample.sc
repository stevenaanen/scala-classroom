import scala.collection.JavaConversions._

object Solution {

//  val values = Array(-1, 3, -4, 5, 1, -6, 2, 1)

  def solution(A: Array[Int]): Int = {

    val array = A.map(_.toLong)

    val maybeEquilibriumIndex = array.indices
      .dropWhile(index => !isEquilibriumIndex(index, array))
      .headOption

    maybeEquilibriumIndex.getOrElse(-1)
  }

  def isEquilibriumIndex(i: Int, A: Array[Long]): Boolean = {
    val leftNumbers = A.take(i)
    val rightNumbers = A.drop(i + 1)
    leftNumbers.sum == rightNumbers.sum
  }

//  values.indices
//  solution(values)

//  solution(Array(5))
}