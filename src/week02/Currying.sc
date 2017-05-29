def product(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 1
  else product(f)(a + 1, b) * f(a)
}

def factorial(n: Int): Int = {
  product(x => x)(1, n)
}

factorial(4)

def accumulator(unitValue: Int)(method: (Int, Int) => Int)(mapper: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) unitValue
  else method(accumulator(unitValue)(method)(mapper)(a + 1, b), mapper(a))
}

accumulator(0)((x, y) => x + y)(x => x)(0,4)