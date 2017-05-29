import scala.util.matching.Regex

object Solution {

  def solution(S: String, T: String): Boolean = {
    val unwrappedS = unwrapQuestionMarks(S)
    val unwrappedT = unwrapQuestionMarks(T)

    if (unwrappedS.length != unwrappedT.length) false
    else {
      val pairs = unwrappedS zip unwrappedT
      pairs.forall(pair => isPossibleCharMatch(pair._1, pair._2))
    }
  }

  val regex: Regex = """\d+""" r

  def unwrapQuestionMarks(s: String) =
    regex.replaceAllIn(s, "?" * _.toString.toInt)

  def isPossibleCharMatch(a: Char, b: Char) =
    a == b || a == '?' || b == '?'


  solution("ap2E", "1pPlE")
}
