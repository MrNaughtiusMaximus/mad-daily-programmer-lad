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
    case a: Int        ⇒ a.toString.toList.map(_.toString.toInt)
    case a: Double     ⇒ a.toString.toList.map(_.toString.toInt) // Will lose accuracy because of rounding
    case a: Long       ⇒ a.toString.toList.map(_.toString.toInt)
    case a: BigDecimal ⇒ a.toString.toList.map(_.toString.toInt)
    case _          ⇒ throw new IllegalArgumentException("The function requires an Int, Double or Long type")
  }

  val num: Long = 123456789012L
  val numList: List[Int] = numberToList(num)

}
