// https://www.reddit.com/r/dailyprogrammer/comments/akv6z4/20190128_challenge_374_easy_additive_persistence/

object Challenge374Easy {

  // Easy solution
  def recurse(i: Int, add: Int = 0): Int =
    if (i >= 10) recurse(i.toString.split("").toList.map(_.toInt).sum, add + 1)
    else add

  // Harder solution without converting into string
  // Could be useful in other situations
  def recurseIntList(i1: Int, add: Int = 0): Int = {

    // Splitting an integer with over 1 digit into a list of Ints
    def splitInt(i2: Int, acc: List[Int] = List()): List[Int] =
      if (i2 / 10 > 0) splitInt(i2 / 10, (i2 % 10) :: acc) else i2 :: acc

    if(splitInt(i1).sum >= 10) recurseIntList(splitInt(i1).sum, add + 1)
    else add + 1
  }

}
