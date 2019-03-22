// https://www.reddit.com/r/dailyprogrammer/comments/a72sdj/20181217_challenge_370_easy_upc_check_digits/

object C370E {

  def findCheckDigit(num: Either[String, Long]): Int = {

    def findDigit(l: List[Int]): Int = {
      val t = l.grouped(2).collect{
        case List(a, b)    ⇒ (a*3) + b // Getting the odd and even numbers
        case List(a)       ⇒ a*3       // Catering for that last lone number
      }.toList.sum
      t % 10 match {
        case 0      ⇒ 0
        case a: Int ⇒ 10 - a
      }
    }

    num match {
      case Left(s) ⇒
        findDigit(List.fill(11-s.length)(0) ++ s.toList.map(_.toString.toInt))

      case Right(i) ⇒
        val a = i.toString.toList.map(_.toString.toInt)
        findDigit(List.fill(11-a.length)(0) ++ a)
    }
  }

  def run(): Unit =
    println("Looking at strings" +
      "\nResult of 4210000526 is " + findCheckDigit(Left("4210000526")),
      "\nResult of 3600029145 is " + findCheckDigit(Left("3600029145")),
      "\nResult of 12345678910 is " + findCheckDigit(Left("12345678910")),
      "\nResult of 1234567 is " + findCheckDigit(Left("1234567")),
      "\nLooking at integers",
      "\nResult of 4210000526 is " + findCheckDigit(Right(4210000526L)),
      "\nResult of 3600029145 is " + findCheckDigit(Right(3600029145L)),
      "\nResult of 12345678910 is " + findCheckDigit(Right(12345678910L)),
      "\nResult of 1234567 is " + findCheckDigit(Right(1234567L)))

}
