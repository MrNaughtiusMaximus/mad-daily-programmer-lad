package NinetyNineScalaProblems

class P03 {
  // Find the N-th element in a list

  val l: List[Int] = List(1, 1, 2, 3, 5, 8)

  // Pattern matching
  def find(n: Int, l: List[Int]): Int = n match {
    case 0 => l.head
    case x => find(n-1, l.tail)
  }

}


