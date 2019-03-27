package ya.pkg

class Collections {

  val example = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  /** Useful collection functions */
  // Returns unique elements
  example.distinct // => List(1, 2, 3, 4, 5, 6, 7, 8, 9) - does nothing as list already has unique elements

  // Iterates over the collection N elements at a time
  example.grouped(2) // => (1,2), (3,4)...
  example.grouped(3) // => (1,2,3), (4,5,6)...

  // Iterates over the collection, moving the starting point by B (default=1) and returning A elements at a time
  example.sliding(2)    // => (1,2), (2,3)..
  example.sliding(2, 2) // => (1,2), (2,4).. === example.grouped(2)
  example.sliding(2, 3) // => (1,2), (4,5)..

  example.scan(0)(_ + _) // => List(0, 1, 3, 6, 10, 15, 21, 28, 36, 45) - similar to fold, but returns a list of the results of every iteration
  example.fold(0)(_ + _) // => 45 == example.sum
  example.sum            // => 45
  example.reduce(_ + _)  // => 45 - Can be used instead of recursion; == example.sum
  example.reduce(_ * _)  // => 362880 == example.product
  example.product        // => 362880 - same as above

  def toEvenAndOddList[A](l: List[A]): List[(Option[A], Option[A])] = l.grouped(2).collect {
    case List(a, b) ⇒ (Option(a), Option(b))
    case List(a)    ⇒ (Option(a), None)
  }.toList

}
