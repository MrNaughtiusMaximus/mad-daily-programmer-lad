import java.time.{Duration, Instant}

import scala.annotation.tailrec
// https://www.reddit.com/r/dailyprogrammer/comments/b0nuoh/20190313_challenge_376_intermediate_the_revised/

object C376I extends App {

  def checkTime(f: ⇒ Unit): Unit = {
    val start = Instant.now()
    f
    val end = Instant.now()
    println("The function runs for " + Duration.between(start,end).toMillis.toString)
  }

  /** Condition for a leap year:
    * - evenly divisible by 4 == leap
    * - evenly by 100 != leap
    * - year % 900 == 200 or 600 is leap
    */
  @tailrec
  def leap(start: Int, end: Int, acc: Int = 0): Int = {
    if (start >= end) acc
    else if (start % 900 == 600 | start % 900 == 200) leap(start + 1, end, acc + 1)
    else if (start % 100 == 0) leap(start + 1, end, acc)
    else if (start % 4 == 0) leap(start + 1, end, acc + 1)
    else leap(start + 1, end, acc)
  }

  /** 2000 to 2097...2100 are 25 leap years
    * 2000 to 2093...2096 are 24 leap years
    * x = (x2 - x1)/4
    * When does the exception start repeating itself? What is the largest common denominator?
    * 3000 == 727
    *
    * 1100 = 1*900 + 200
    * 1500 = 1*900 + 600
    * ... starts repeating
    * 2000 = 2*900 + 200
    * 2400 = 2*900 + 600
    * 2900 = 3*900 + 200
    * 3300 = 3*900 + 600
    * 3800 = 4*900 + 200
    * 4200 = 4*900 + 600
    * 4700 = 5*900 + 200
    * 5100 = 5*900 + 600
    */


}
