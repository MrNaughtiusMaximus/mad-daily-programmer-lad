import org.scalatest.FlatSpec

class Challenge375 extends FlatSpec {

  "Challenge 374" should "return 2 when supplying 1234" in {
    assert(Challenge374Easy.recurse(1234) === 2)
  }

  it should "return 2 when supplying 9876" in {
    assert(Challenge374Easy.recurse(9876) === 2)
  }

  it should "return 1 when supplying 13" in {
    assert(Challenge374Easy.recurse(13) === 1)
  }

  it should "return 3 when supplying 199" in {
    assert(Challenge374Easy.recurse(199) === 3)
  }

  "Challenge 374 Bonus" should "return 2 when supplying 1234" in {
    assert(Challenge374Easy.recurseIntList(1234) === 2)
  }

  it should "return 2 when supplying 9876" in {
    assert(Challenge374Easy.recurseIntList(9876) === 2)
  }

  it should "return 1 when supplying 13" in {
    assert(Challenge374Easy.recurseIntList(13) === 1)
  }

  it should "return 3 when supplying 199" in {
    assert(Challenge374Easy.recurseIntList(199) === 3)
  }


}
