
  sqrt(2)
  
  def sqrt(x: Double) = {
    def sqrtIter(estimation: Double, x: Double): Double =
      if(isGoodEnough(estimation, x)) estimation
      else sqrtIter(improve(estimation, x), x)
    def isGoodEnough(estimation: Double, x: Double) = {
      val square = estimation.
      Math.abs(estimation * estimation - x) / x < 0.001

    }
    def improve(estimation: Double, x: Double) = {
      val quotient = x / estimation
      (estimation + quotient) / 2
    }

    sqrtIter(1, x)
  }
