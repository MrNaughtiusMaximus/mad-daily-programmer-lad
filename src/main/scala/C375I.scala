import scala.annotation.tailrec
// https://www.reddit.com/r/dailyprogrammer/comments/aq6gfy/20190213_challenge_375_intermediate_a_card/

//noinspection TypeAnnotation
object C375I {

//  val ex0: String = "0100110" // why does this return null? Is it to do with the way it is instantiated? Def or lazy vals work tho => because I was extending App
  val ex1: String = "0100110"
  val ex2: String = "01001100111"
  val ex3: String = "100001100101000"

  def rf(s: String, s1: String, s2: String): String = s.replaceFirst(s1, s2)
  def findFlippedCards(l: String, is: List[Int] = List()): List[Int] = l.indices.filter(a ⇒ l(a) == '.').distinct.filter(!is.contains(_)).toList

  // Get all possible permutations for ".01"
  "000111...".combinations(3).flatMap(_.permutations.map(_.toString).toList).toList
  val r1 = ("^10".r, ".1")
  val r2 = ("^1\\.".r, "..")
  val r3 = ("01$".r, "1.")
  val r4 = (".1$".r, "..")
  val r5 = ("\\.10".r, "..1")
  val r6 = ("\\.11".r, "..0")
  val r7 = ("\\.1.".r, "...")
  val r8 = ("010".r, "1.1")
  val r9 = ("110".r, "0.1")
  val r10 = ("011".r, "1.0")
  val r11 = ("111".r, "0.0")

  val lr = List(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)

  def flipCards(s: String): Option[String] =
    (for(r ← lr if r._1.findFirstIn(s).isDefined) yield rf(s, r._1.regex, r._2)).headOption

  @tailrec
  def run(s: String, acc: List[Int] = List()): Unit = {
    println(s"s is $s and acc is $acc")
    if (s.distinct == ".") println(acc.mkString(" "))
    else if (flipCards(s).isEmpty) println("no solution")
    else run(flipCards(s).get, acc ::: findFlippedCards(flipCards(s).get, acc))
  }

}
