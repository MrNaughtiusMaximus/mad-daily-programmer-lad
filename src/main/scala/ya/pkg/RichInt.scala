package ya.pkg

import scala.annotation.tailrec

class RichInt {

  // TODO How to make this part of every Int type that I call? Do I need to create implicit RichInt trait? How?
  @tailrec
  final def numLength(i: Int, acc: Int = 1): Int = if (i >= scala.math.pow(10, acc)) numLength(i, acc + 1) else acc

  //  TODO Ask Luke - how to return the same Type as was given
  //  def NumberToList[A](i: A): List[A] = i match {
  //    case Int    ⇒ i.toString.toList.map(_.toString.toInt)
  //    case Double ⇒ i.toString.toList.map(_.toString.toDouble)
  //    case Long   ⇒ i.toString.toList.map(_.toString.toLong)
  //    case _      ⇒ throw new IllegalArgumentException("The function requires an Int, Double or Long type")
  //  }

  def numberToList[A](i: A): List[Int] = i match { // Rename toList when you figure out how to add to the implicit conversions
    case Int        ⇒ i.toString.toList.map(_.toString.toInt)
    case Double     ⇒ i.toString.toList.map(_.toString.toInt) // Will lose accuracy because of rounding
    case Long       ⇒ i.toString.toList.map(_.toString.toInt)
    case BigDecimal ⇒ i.toString.toList.map(_.toString.toInt)
    case _          ⇒ throw new IllegalArgumentException("The function requires an Int, Double or Long type")
  }

  val example = List("1", "2", "1", "2", "1", "2", "1", "2", "1", "2", "1", "2")
  val num: Long = 123456789012L
  val numList: List[Int] = numberToList(num)

  // TODO Ask Luke
  //  Trying to:
  // 1) Take a list;
  // 2) Group the elements in it by couples, e.g. odd and even index - (l(0), l(1))
  // 3) Trying to add a case for when the list is odd-numbered, e.g. when there will be 1 last element without a buddy - How?
//  def tupleList[A](l: List[A]): List[(A, A)] = l.grouped(2).collect {
//    case List(a, b) ⇒ (a, b)
//    case List(a)    ⇒ (a, None)
//  }.toList

  /** Useful collection functions */ //TODO Move somewhere else when
  example.distinct // Returns unique elements - not really necessary here
  example.grouped(2) // Iterates over the collection N elements at a time, e.g. grouped(2) will return (1,2), (3) will return (1,2,3), etc.

}
