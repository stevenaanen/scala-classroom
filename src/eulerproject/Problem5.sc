def isDivisibleByAll(number: Int, divisors: Range) = divisors.forall(number % _ == 0)

val range = 1 to 20
Stream.from(range.end, range.end)
  .find(isDivisibleByAll(_, range))
