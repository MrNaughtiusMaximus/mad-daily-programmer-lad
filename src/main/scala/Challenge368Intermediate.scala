import scala.util.Random
// https://www.reddit.com/r/dailyprogrammer/comments/9z3mjk/20181121_challenge_368_intermediate_singlesymbol/

object Challenge368Intermediate extends C368A1 with C368A2

sealed trait C368A1 {

  def createMatrix(n: Int): Vector[Vector[Boolean]] = Vector.fill(n)(Vector.fill(n)(Random.nextBoolean()))

  // Used for displaying the result a bit neater
  def render(v: Vector[Vector[Boolean]]): Unit = v.foreach(println(_))

  def getValidMatrix(n: Int): Vector[Vector[Boolean]] = {
    val x = createMatrix(n)
    if(check(x)) x else getValidMatrix(n)
  }

  def check(l: Vector[Vector[Boolean]]): Boolean = {

    // Checking whether there are any squares starting from position (x,y), e.g.
    // checking if (x,y) == (x,1) == (1,1) == (1, y), then
    // checking if (x,y) == (x,2) == (2,2) == (2, y), etc.
    def recurse(x: Int = 0, y: Int = 0, e: Int = 1): Boolean = {
      if (e == l.length) true
      else if (l(x)(y) && l(x)(e) && l(e)(y) && l(e)(e)) false
      else if (e < l.length) recurse(x=x, y=y, e + 1)
      else true
    }

    // Moving the starting position diagonally, e.g. (x,y) => (0,0) => (1,1)
    def recurseDiagonal(i: Int = 0): Boolean = if(i < l.length - 1) {
      if(recurse(x = i, y = i)) recurseDiagonal(i + 1) else false
    } else true

    // Moving the starting position diagonally, e.g. (x,y) => (0,0) => (1,1)
    def recurseReverseDiagonal(i: Int = l.length - 1): Boolean = if (i > 1) {
      if (recurse(x = i, y = i)) recurseReverseDiagonal(i - 1) else false
    } else true

    // Moving the starting position vertically, e.g. (x,y) => (0,0) => (0,1)
    def recurseVertical(i: Int = 0): Boolean = if(i < l.length - 1) {
      if (recurse(y = i)) recurseVertical(i + 1) else false
    } else true

    // Moving the starting position horizontally, e.g. (x,y) => (0,0) => (1,0)
    def recurseHorizontal(i: Int = 0): Boolean = if(i < l.length - 1) {
      if (recurse(x = i)) recurseHorizontal(i + 1) else false
    } else true

    recurseDiagonal() && recurseReverseDiagonal() && recurseVertical() && recurseHorizontal()
  }
}

sealed trait C368A2 extends C368A1 {


  //  def checkMatrices(seq: Seq[Vector[Vector[Boolean]]]): Seq[Vector[Vector[Boolean]]] = seq.filter(func(_))

  //  def generateMatrices(n: Int): Vector[Vector[Boolean]] = Vector.fill(n*n)(Random.nextBoolean()).combinations(n).flatMap(_.permutations.toVector).toVector

  //  def generateAllPossibleGrids(n: Int): Vector[Vector[Vector[Boolean]]] = generateMatrices(n).combinations(n).toVector

  //  def recurse(l: Vector[Vector[Boolean]], x: Int = 0, y: Int = 0, e: Int = 1): Boolean = {
  //    if (e == l.length) true
  //    else if (l(x)(y) && l(x)(e) && l(e)(y) && l(e)(e)) {
  //      println(s"x = $x")
  //      println(s"y = $y")
  //      println(s"Index = $e")
  //      l.foreach(println(_))
  //      println(s"\n ${l(x)(y)} && ${l(x)(e)} && ${l(e)(y)} && ${l(e)(e)}")
  //      false
  //    }
  //    else if (e < l.length) recurse(l, x = x, y = y, e = e + 1)
  //    else true
  //  }

}
