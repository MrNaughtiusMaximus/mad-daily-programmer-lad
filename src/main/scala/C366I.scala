import java.time.{Duration, Instant}

import scala.annotation.tailrec
import scala.concurrent.{Future, ExecutionContext ⇒ Ec, ExecutionContextExecutor ⇒ Ece}
import scala.io.Source
import scala.util.{Failure, Success}
// https://www.reddit.com/r/dailyprogrammer/comments/99d24u/20180822_challenge_366_intermediate_word_funnel_2/

object C366I {

  val words: Vector[String] = Source.fromFile("enable1.txt").getLines().toVector

  def sliceWord(s: String, i: Int): String = s.slice(0, i - 1) + s.slice(i, s.length)

  @tailrec
  def findWord(s: String, acc: Int = 1): String =
    if (acc > s.length) ""
    else if (words.contains(sliceWord(s, acc))) sliceWord(s, acc)
    else findWord(s, acc + 1)

  @tailrec
  def funnelWord(funnel: String, acc: Int = 1): Int =
    if (words.contains(funnel)) {
      if (words.contains(findWord(funnel))) funnelWord(findWord(funnel), acc + 1) else acc
    } else acc


  // Used for testing concepts
  def run(begin: Int, stop: Int): Unit = {
//    val start = Instant.now()
    for (a ← words.filter(_.length > 9).slice(begin, stop)) funnelWord(a)
//    val end = Instant.now()
//    Duration.between(start,end).toMillis.toString
  }

  def checkTime(f: ⇒ Unit): Unit = {
    val start = Instant.now()
    f
    val end = Instant.now()
    println("The function runs for " + Duration.between(start,end).toMillis.toString)
  }

  //BONUS
  def findWordWithFunnelOf(n: Int, vector: Vector[String]): Vector[String] =
    for (word ← vector.filter(_.length > n-1) if funnelWord(word) == n) yield word

  // Does same as above, but is more concise
  def findWordWithFunnelOfUsingFilter(n: Int, vector: Vector[String]): Vector[String] =
    vector.filter(funnelWord(_) == 10)

  def splitVector(vector: Vector[String]): (Vector[String], Vector[String]) =
    (vector.take(vector.length/2), vector.drop(vector.length/2))

  implicit val ec: Ece = Ec.global

  // You need an Execution Context to run Futures
  def runFunc(): Unit = {
    val res1 = Future(findWordWithFunnelOf(10, splitVector(splitVector(words.filter(_.length > 9))._1)._1))
    val res2 = Future(findWordWithFunnelOf(10, splitVector(splitVector(words.filter(_.length > 9))._1)._2))
    val res3 = Future(findWordWithFunnelOf(10, splitVector(splitVector(words.filter(_.length > 9))._2)._1))
    val res4 = Future(findWordWithFunnelOf(10, splitVector(splitVector(words.filter(_.length > 9))._2)._2))

    res1.onComplete{
      case Success(a) ⇒ println(s"Res1 found $a")
      case Failure(a) ⇒ println(s"Res1 Didn't find anything!")
    }

    res2.onComplete{
      case Success(a) ⇒ println(s"Res2 found $a")
      case Failure(a) ⇒ println(s"Res2 Didn't find anything!")
    }

    res3.onComplete{
      case Success(a) ⇒ println(s"Res3 found $a")
      case Failure(a) ⇒ println(s"Res3 Didn't find anything!")
    }

    res4.onComplete{
      case Success(a) ⇒ println(s"Res4 found $a")
      case Failure(a) ⇒ println(s"Res4 Didn't find anything!")
    }
  }
}
