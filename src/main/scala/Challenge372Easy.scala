// https://www.reddit.com/r/dailyprogrammer/comments/afxxca/20190114_challenge_372_easy_perfectly_balanced/

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

  // Bonus solution
  // 1. Go through list to see which letters it has
  // 2. Filter list to see how many instances of each letter there are
  // 3. Compare them
  def check(s: String): Boolean = {

    def identifyLetters(s: String, acc: List[Char] = List()): List[Char] =
      if(!s.isEmpty) identifyLetters(s.tail.filter(!s.head.toString.contains(_)), s.head :: acc) else acc

    val lc = identifyLetters(s)

    if (lc.isEmpty || lc.length == 1) true
    else {
      def recurse(l2: List[Char], acc: List[Int] = List()): List[Int] = {
        def getLength(i: List[Char]): Int = s.filter(i.head.toString.contains(_)).length

        if (l2.nonEmpty) recurse(l2.tail, getLength(l2) :: acc) else acc
      }

      def confirm(li: List[Int]): Boolean = {
        if (li.head == li.tail.head && li.length > 2) confirm(li.tail)
        else if (li.head != li.tail.head && li.length > 1) false
        else true
      }

      confirm(recurse(lc))
    }
  }


}
