// https://www.reddit.com/r/dailyprogrammer/comments/akv6z4/20190128_challenge_374_easy_additive_persistence/

object Challenge372Easy {

  def recurse(string: String): Boolean = {
    def recurseInner(s: String, accx: Int = 0, accy: Int = 0): (Int, Int) = {
      if(!s.isEmpty && s.head == 'x') recurseInner(s.tail, accx + 1, accy)
      else if(!s.isEmpty && s.head == 'y') recurseInner(s.tail, accx, accy + 1)
      else (accx, accy)
    }
    val (a, b) = recurseInner(string)
    a == b
  }

}
