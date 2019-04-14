package NinetyNineScalaProblems

class P06 {
  //  Find out whether a list is a palindrome

  val l: List[Int] = List(1, 1, 2, 3, 5, 8)

  // Pattern matching
  def palindrome(l: List[Int]): Boolean =
    l.reverse == l

}


