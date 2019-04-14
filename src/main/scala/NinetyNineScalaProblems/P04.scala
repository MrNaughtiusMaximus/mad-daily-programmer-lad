package NinetyNineScalaProblems

class P04 {
  // Find the number of elements in a list

  val l: List[Int] = List(1, 1, 2, 3, 5, 8)

  // Pattern matching
  def length(l: List[Int], acc: Int = 0): Int = l match {
    case Nil => acc
    case h :: t => length(l.tail, acc + 1)
  }

  // You can also just do l.length, but that defeats the purpose of the exercise I guess
}


