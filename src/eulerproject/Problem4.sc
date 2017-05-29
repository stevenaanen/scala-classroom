import scala.math._

def findHighestPalindromicNumberWithProductOfDigits(length: Int) = {
  val max = pow(10, length).toInt - 1
  val validCombis: Seq[(Int, Int)] = for {
    num1 <- 0 to max
    num2 <- 0 to num1 if productIsPalindromic(num1, num2)
  } yield (num1, num2)

  validCombis
    .zip(validCombis.map(t => t._1 * t._2))
    .reduce((a, b) => if (a._2 > b._2) a else b)
}

def productIsPalindromic(num1: Int, num2: Int) = isPalindromic((num1 * num2).toString)

def isPalindromic(testCase: String) = testCase.length % 2 match {
  case 0 => testCase startsWith testCase.substring(testCase.length / 2).reverse
  case _ => false
}


isPalindromic("293392")
productIsPalindromic(91,99)

findHighestPalindromicNumberWithProductOfDigits(3)