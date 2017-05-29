object FiboFun {
  val fib = {
    def nextFib(prev: List[Int]): Stream[Int] =
      prev.sum #:: nextFib(List(prev.reverse.head, prev.sum))

    nextFib(List(1,1))
  }

  fib.filter(isEven).takeWhile(_ <= 4000000).sum

  def isEven(n: Int) = n % 2 == 0
}

object PrimeFactors {

}

val total = 5*7*13*29

def primes = {
  def composePrimes(previousPrimes: Seq[Int], numberToTry: Int): Stream[Int] = {
    if (isDivisible(numberToTry, previousPrimes))
      composePrimes(previousPrimes, numberToTry + 1)
    else
      numberToTry #:: composePrimes(previousPrimes :+ numberToTry, numberToTry + 1)
  }

  def isDivisible(n: Int, seq: Seq[Int]) =
    seq.exists(n % _ == 0)

  2 #:: composePrimes(Seq(2),3)
}

def findPrimeFactors(n: BigInt): List[Int] = {
  def continue(nextPrimes: Stream[Int], res: BigInt): List[Int] = res match {
    case i if i == BigInt(1) => List.empty
    case _ => {
      val prime = nextPrimes.head
      if (res % prime == 0) prime :: continue(nextPrimes, res / prime)
      else continue(nextPrimes.tail, res)
    }
  }
  continue(primes, n)
}

primes.take(12).toList

findPrimeFactors(BigInt(600851475143L)).reverse.head
