// https://www.reddit.com/r/dailyprogrammer/comments/aphavc/20190211_challenge_375_easy_print_a_new_number_by/

object Challenge375Easy extends App {

  def transform1(s: String): String = s.split("").toList.map(x ⇒ (x.toInt + 1).toString).mkString("")

  def transform2(s: String): String = s.map(x ⇒ (x.toString.toInt + 1).toString).mkString("")

  def transform3(s: String): String = (for( char ← s) yield (char.toString.toInt + 1).toString).mkString("")

  def transform4(s: String): String = s.toList.map(_.toString).fold("")((acc, s) ⇒ acc ++ (s.toInt + 1).toString).mkString("")

}
