import scala.util.Random
// https://www.reddit.com/r/dailyprogrammer/comments/9z3mjk/20181121_challenge_368_intermediate_singlesymbol/

object Challenge368Intermediate {

  // Square grid, which is NxN, e.g. 5x5
  // No axis-aligned square must be present

  // One solution is to create all possible combinations, then eliminate them
  // The other is to set conditions for creation of these matrices (which would be much more efficient)
  def createMatrix(n: Int): List[List[Boolean]] = List.fill(n)(List.fill(n)(Random.nextBoolean()))

  // Need to create a sequence of all createMatrix

  def checkMatrices(seq: Seq[List[List[Boolean]]]): Seq[List[List[Boolean]]] = seq.filter(func(_))

  def generateMatrices(n: Int): List[List[Boolean]] = List.fill(n*n)(Random.nextBoolean()).combinations(n).flatMap(_.permutations.toList).toList

  def generateAllPossibleGrids(n: Int): List[List[List[Boolean]]] = generateMatrices(n).combinations(n).toList

  // Need to create a function to check whether there is such an axis-aligned square in the matrix
//  def checkSquare(list: List[List[Boolean]]): Boolean = {
//    // Here, we can use n from createMatrix, but take away 1
//    // Check whether n(0)(0) == n(0)(1) == n(1)(0) == n(1)(1), then
//    // check whether n(0)(0) == n(0)(2) == n(2)(0) == n(2)(2), then
//    // check whether n(0)(0) == n(0)(3) == n(3)(0) == n(3)(3), then try to build a formula from that
//
//    // just checking the initial edge of the matrix, e.g. first point will be n(0)(0)
//
//    ???
//  }

  def recurse(l: List[List[Boolean]], x: Int = 0, y: Int = 0, e: Int = 1): Boolean = {
    if (e == l.length) true
    else if (l(x)(y) && l(x)(e) && l(e)(y) && l(e)(e)) {
      println(s"x = $x")
      println(s"y = $y")
      println(s"Index = $e")
      l.foreach(println(_))
      println(s"\n ${l(x)(y)} && ${l(x)(e)} && ${l(e)(y)} && ${l(e)(e)}")
      false
    }
    else if (e < l.length) recurse(l, x = x, y = y, e = e + 1)
    else true
  }

  // Increasing the area of the square
  def func(l: List[List[Boolean]]): Boolean = {

    def recurse(x: Int = 0, y: Int = 0, e: Int = 1): Boolean = {
      if (e == l.length) true
      else if (l(x)(y) && l(x)(e) && l(e)(y) && l(e)(e)) {
        println(s"x = $x")
        println(s"y = $y")
        println(s"Index = $e")
        l.foreach(println(_))
        println(s"\n ${l(x)(y)} && ${l(x)(e)} && ${l(e)(y)} && ${l(e)(e)}")
        false
      }
      else if (e < l.length) recurse(x=x, y=y, e + 1)
      else true
    }

    // Moving the starting point diagonally, e.g. (x,y) => (0,0) => (1,1)
    def recurseDiagonal(i: Int = 0): Boolean = if(i < l.length - 1) {
      if(recurse(x = i, y = i)) recurseDiagonal(i + 1) else false
    } else true

    // Moving the starting point diagonally, e.g. (x,y) => (0,0) => (1,1)
//    def recurseReverseDiagonal(i: Int = l.length): Boolean = {
//      println(s"Iteration $i")
//      val r = recurse(x = i, y = i)
//      if (i < l.length - 1 && r) recurseReverseDiagonal(i - 1)
//      else true
//    }

    // Moving the starting point verticaly, e.g. (x,y) => (0,0) => (0,1)
    def recurseVertical(i: Int = 0): Boolean = if(i < l.length - 1) {
      if (recurse(y = i)) recurseVertical(i + 1) else false
    } else true

    // Moving the starting point horizontally, e.g. (x,y) => (0,0) => (1,0)
    def recurseHorizontal(i: Int = 0): Boolean = if(i < l.length - 1) {
      if (recurse(x = i)) recurseVertical(i + 1) else false
    } else true

    recurseDiagonal() && recurseVertical() && recurseHorizontal()
  }
}
