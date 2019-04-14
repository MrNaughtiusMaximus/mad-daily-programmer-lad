package NinetyNineScalaProblems

class P01 {

  val l: List[Int] = List(1, 1, 2, 3, 5, 8)

  // Pattern matching
  def lastPattern(l: List[Int]): Int = l match {
    case Nil => 0
    case h :: Nil => h
    case h :: t => lastPattern(t)
  }

  // If statements
  def lastIf(l: List[Int]): Int =
    if(l.length > 1) lastIf(l.tail)
    else l.head

  /** You can do the below two, but it's inefficient */
  def lastReduce(l: List[Int]): Int =
    l.reduce((_, b) => b)

  def lastFold(l: List[Int]): Int =
    l.fold(0)((_, b) => b)

  /** This seems like the most logical solution */
  def lastReverse(l: List[Int]): Int =
    l.reverse.headOption.getOrElse(0)

  def main(args: Array[String]): Unit = {
    println("lastPattern(l)")
    lastPattern(l)
    println("lastIf(l)")
    lastIf(l)
    println("lastReduce(l)")
    lastReduce(l)
    println("lastFold(l)")
    lastFold(l)
    println("lastReverse(l)")
    lastReverse(l)
  }

}


