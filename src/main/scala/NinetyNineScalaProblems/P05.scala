package NinetyNineScalaProblems

class P05 {
  // Reverse a list

  val l: List[Int] = List(1, 1, 2, 3, 5, 8)

  // Pattern matching
  def reverse(l: List[Int]): List[Int] =
//    l.fold(List[Int]()){ ... }      // All 3 definitions are valid
//    l.fold[List[Int]](Nil){ ... }   //
    l.foldLeft(Nil: List[Int])((x, y) => y :: x)

  // You can also just do l.reversed, but that defeats the purpose of the exercise I guess
}


