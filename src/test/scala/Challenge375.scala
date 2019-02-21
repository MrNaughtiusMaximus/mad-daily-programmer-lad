import org.scalatest.FlatSpec

class Challenge375 extends FlatSpec {

  "Transform method in Challenge 375 Easy" should "return 10109 when supplying 998" in {
    assert(Challenge375Easy.transform1("998") === "10109")
  }

  it should "return 998 when supplying 887" in {
    assert(Challenge375Easy.transform1("887") === "998")
  }

}
