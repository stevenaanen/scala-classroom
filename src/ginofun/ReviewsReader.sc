val docs: List[String] = List("it's awsome", "sucks", "dont work!!!!", "huh")

val reviews = toReviewList(docs, 0)
val reviews1 = toReviewList1(docs, 0)

case class Review(msg: String, id: Int)

def toReviewList(strings: List[String], id: Int): List[Review] = strings match {
  case Nil => List()
  case head :: tail => Review(head, id) :: toReviewList(tail, id + 1)
}

def toReviewList1(strings: List[String], id: Int): List[Review] =
  (strings foldRight List[Review]())((str: String, xs: List[Review]) => Review(str, xs.head.id + 1) :: xs)

def toReviewList2(strings: List[String], id: Int): List[Review] =
  (strings foldLeft List[Review]())((str: String, xs: List[Review]) => Review(str, xs.head.id + 1) :: xs)