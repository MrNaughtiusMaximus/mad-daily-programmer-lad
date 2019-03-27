// https://www.reddit.com/r/dailyprogrammer/comments/8i5zc3/20180509_challenge_360_intermediate_find_the/

object C360I {

  val url: String    = "https://opensky-network.org/api/states/all"
  val result: String = scala.io.Source.fromURL(url).mkString

  // Eifel Tower
  // lamax = 48.8584 N
  // 2.2945 E

  //  John F. Kennedy Airport:
  //  40.6413 N
  //  73.7781 W

}
