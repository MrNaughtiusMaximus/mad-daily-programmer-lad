import java.time.{Duration, Instant}

import ya.pkg.Utils

import scala.annotation.tailrec
// https://www.reddit.com/r/dailyprogrammer/comments/b0nuoh/20190313_challenge_376_intermediate_the_revised/

object C376I extends Utils {

  def checkTime(f: ⇒ Unit): Unit = {
    val start = Instant.now()
    print(s"Starting time is ${start.toString}")
    f
    val end = Instant.now()
    print(s"Ending time is ${end.toString}")
    println("The function runs for " + Duration.between(start, end).toMillis.toString)
  }

  def test(): Boolean = {
    val res = leap(123456789101112L, 1314151617181920L)
    println(s"Result is $res")
    res == 288412747246240L
  }

  /** Condition for a leap year:
    * - evenly divisible by 4 == leap
    * - evenly by 100 != leap
    * - year % 900 == 200 or 600 is leap
    */
  @tailrec
  def leap(st: Long, end: Long, acc: Long = 0): Long = {
    if (st >= end) acc
    else if (st % 4 != 0) leap(st + 1, end, acc)
    else if (st > 1500 && end - st > 4500 && st % 1500 == 0 && ((st / 1500) - 1) % 3 == 0) {
      val x = (end-st)/4500
      if (st + x*4500 < end) leap(st + x*4500, end, acc + 1090*x)
      else leap(st + (x-1)*4500, end, acc + 1090*(x-1))
    }
    else if (st % 900 == 600 | st % 900 == 200) leap(st + 1, end, acc + 1)
    else if (st % 100 == 0) leap(st + 1, end, acc)
    else leap(st + 1, end, acc + 1)
  }

}
