package NinetyNineScalaProblems

class P07 {
  //   Flatten a nested list structure

  val l = List(List(1, 1), 2, List(3, List(5, 8)))

  // Pattern matching - without using any built-in functions
  def flatten(l: List[Any], acc: List[Any] = Nil): List[Any] = {
    s"l is $l and acc is $acc"
    l match {
      case Nil => acc
      case h :: t => h match {
        case a: List[_] => flatten(l.tail, acc ::: flatten(a))
        case b          => flatten(l.tail, acc :+ b)
      }
    }
  }

  def flattenIf(l: List[Any], acc: List[Any] = Nil): List[Any] = {
    if(l.isEmpty) acc
    else if(l.head.isInstanceOf[List[_]]) acc ::: flatten(l)
    else acc :+ l.head
  }

  def siteSolution(l: List[Any]): List[Any] = l.flatMap{
    case as: List[_] => flatten(as)
    case b           => List(b)
  }

  // The exercise seems to be weird as I don't think you should have to deal with lists of different types, e.g. List[Int] and Ints
  // Seems like poor data structuring and something that can be handled earlier on
}


