class Rational(x: Int, y: Int) {
  var numer = x
  var denom = y

  def neg = numer = numer * -1

  override def toString = numer + "/" + denom
}

val rat = new Rational(2,3)
rat.neg
rat