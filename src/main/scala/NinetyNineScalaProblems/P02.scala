package NinetyNineScalaProblems

class P02 {

  val l: List[Int] = List(1, 1, 2, 3, 5, 8)

  // Pattern matching
  def penultimate(l: List[Int]): Int = l match {
    case Nil => 0
    case h :: Nil => 0
    case h :: t if t.length == 1 => h
    case h :: t                  => penultimate(t)
  }

  // If statements
  def penultimateIf(l: List[Int]): Int =
    if(l.length > 2) penultimateIf(l.tail)
    else l.head

}


