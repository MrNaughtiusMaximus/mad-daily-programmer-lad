import scala.util.Random
// https://www.reddit.com/r/dailyprogrammer/comments/9z3mjk/20181121_challenge_368_intermediate_singlesymbol/

object Challenge368Intermediate {

  // Square grid, which is NxN, e.g. 5x5
  // No axis-aligned square must be present

  // One solution is to create all possible combinations, then eliminate them
  // The other is to set conditions for creation of these matrices (which would be much more efficient)
  def createMatrix(n: Int): List[List[Boolean]] = List.fill(n)(List.fill(n)(Random.nextBoolean()))

  // Need to create a function to check whether there is such an axis-aligned square in the matrix
  def checkSquare(list: List[List[Boolean]]): Boolean = {
    // Here, we can use n from createMatrix, but take away 1
    // Check whether n(0)(0) == n(0)(1) == n(1)(0) == n(1)(1), then
    // check whether n(0)(0) == n(0)(2) == n(2)(0) == n(2)(2), then
    // check whether n(0)(0) == n(0)(3) == n(3)(0) == n(3)(3), then try to build a formula from that

    // just checking the initial edge of the matrix, e.g. first point will be n(0)(0)

    ???
  }

  def recurse(list: List[List[Boolean]], i: Int = 1): Boolean = {
    if(i == list.length) true
    if(list(0)(0) && list(0)(i) && list(i)(0) && list(i)(i)) false
    else if(i < list.length) recurse(list, i+1)
    else true
  }

}
