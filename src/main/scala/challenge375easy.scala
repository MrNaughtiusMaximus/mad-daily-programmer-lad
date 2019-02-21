// https://www.reddit.com/r/dailyprogrammer/comments/aphavc/20190211_challenge_375_easy_print_a_new_number_by/

object challenge375easy extends App {

  def transform1(s: String): String = s.split("").toList.map(x ⇒ (x.toInt + 1).toString).mkString("")

  def transform2(s: String): String = s.map(x ⇒ (x.toString.toInt + 1).toString).mkString("")

  def transform3(s: String): String = (for( char ← s) yield (char.toString.toInt + 1).toString).mkString("")

  // TODO Ask Luke why fold returns Any in this case
  def transform4(s: String): String = s.fold("")((acc, s) ⇒ acc + (s.toString.toInt + 1).toString)
//    .mkString("")

}
