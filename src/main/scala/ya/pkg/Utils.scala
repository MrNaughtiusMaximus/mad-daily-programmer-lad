package ya.pkg

import java.time.{Duration, Instant}

trait Utils {

  def checkRunTimeOfFunc(f: => Unit): Unit = {
    val start = Instant.now()
    f
    val end = Instant.now()
    println("The function runs for " + Duration.between(start,end).toMillis.toString)
  }

}
