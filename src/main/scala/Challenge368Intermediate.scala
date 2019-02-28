
import scala.annotation.tailrec
import scala.util.Random
// https://www.reddit.com/r/dailyprogrammer/comments/9z3mjk/20181121_challenge_368_intermediate_singlesymbol/

// TODO Optimise for N=10
object Challenge368Intermediate extends NewAttempt {

  def allEqual[T](t: T*): Boolean = if (t.nonEmpty) t.forall(_ == t.head) else false

  def createMatrix(n: Int): Vector[Vector[Int]] = Vector.fill(n)(Vector.fill(n)(Random.nextInt(2)))

  // Used for displaying the result a bit neater
  def render[T](v: Vector[Vector[T]]): Unit = v.foreach(println(_))

  @tailrec
  def getValidMatrix(n: Int, i: Int = 0): Vector[Vector[Int]] = {
    println(s"\n***\nIteration $i")
    val x = createMatrix(n)
    if (recurseDiagonal(l = x)) x else getValidMatrix(n, i + 1)
  }

  @tailrec
  def recurseDiagonal(i: Int = 0, l: Vector[Vector[Int]]): Boolean = if (i < l.length - 1) {
    if (recurse(i, i, i + 1, i + 1, l)) {
      if (recurseHorizontal(i, i, l)) {
        if (recurseVertical(i, i, l)) {
          recurseDiagonal(i + 1, l)
        } else false
      } else false
    } else false
  } else true

  @tailrec
  def recurseVertical(i: Int = 0, xpos: Int = 0, l: Vector[Vector[Int]]): Boolean = if (i < l.length - 1) {
    if (recurse(xpos, i, xpos + 1, i + 1, l)) recurseVertical(i + 1, xpos, l) else false
  } else true

  // Moving the starting position horizontally, e.g. (x,y) => (0,0) => (1,0)
  @tailrec
  def recurseHorizontal(i: Int = 0, ypos: Int = 0, l: Vector[Vector[Int]]): Boolean = if (i < l.length - 1) {
    if (recurse(i, ypos, i + 1, ypos + 1, l)) recurseHorizontal(i + 1, ypos, l) else false
  } else true

  @tailrec
  def recurse(x: Int = 0, y: Int = 0, a: Int = 1, b: Int = 1, l: Vector[Vector[Int]]): Boolean = {
    if (a == l.length || b == l.length) true
    else if (allEqual(x, y, a, b)) true
    else if (allEqual(l(x)(y), l(x)(b), l(a)(y), l(a)(b))) false
    else if (a < l.length && b < l.length) recurse(x, y, a + 1, b + 1, l)
    else true
  }


  // OLD ATTEMPT - returns true when recurseDiagonal returns false - not sure why?
  def check(vector: Vector[Vector[Int]]): Boolean = {

    // Checking whether there are any squares starting from position (x,y) and expanding, e.g.
    // checking if (x,y) == (x,1) == (1,1) == (1, y), then
    // checking if (x,y) == (x,2) == (2,2) == (2, y), etc.
    @tailrec
    def recurse(x: Int = 0, y: Int = 0, a: Int = 1, b: Int = 1): Boolean = {
      if (a == vector.length || b == vector.length) true
      else if (allEqual(x, y, a, b)) true
      else if (allEqual(vector(x)(y), vector(x)(b), vector(a)(y), vector(a)(b))) {
        println(s"x=$x   y=$y    a=$a   b=$b")
        println(s"${vector(x)(y)}, ${vector(x)(b)}, ${vector(a)(y)}, ${vector(a)(b)}")
        render(vector)
        println(s"\n***")
        false
      }
      else if (a < vector.length && b < vector.length) recurse(x, y, a + 1, b + 1)
      else true
    }

    @tailrec
    def recurseDiagonal(i: Int = 0): Boolean = if (i < vector.length - 1) {
      if (recurse(i, i, i + 1, i + 1)) {
        if (recurseHorizontal(i, i)) {
          if (recurseVertical(i, i)) {
            recurseDiagonal(i + 1)
          } else false
        } else false
      } else false
    } else true

    // Moving the starting position vertically, e.g. (x,y) => (0,0) => (0,1)
    @tailrec
    def recurseVertical(i: Int = 0, xpos: Int = 0): Boolean = if (i < vector.length - 1) {
      if (recurse(xpos, i, xpos + 1, i + 1)) recurseVertical(i + 1) else false
    } else true

    // Moving the starting position horizontally, e.g. (x,y) => (0,0) => (1,0)
    @tailrec
    def recurseHorizontal(i: Int = 0, ypos: Int = 0): Boolean = if (i < vector.length - 1) {
      if (recurse(i, ypos, i + 1, ypos + 1)) recurseHorizontal(i + 1) else false
    } else true

    recurseDiagonal()
  }

}

trait NewAttempt {
  
  def generateNumber(n: Int): List[Int] = List.tabulate(n){
      case a if a <= n+1 ⇒ Random.nextInt(2)
      case _             ⇒ Random.nextInt(2)
    }

}
