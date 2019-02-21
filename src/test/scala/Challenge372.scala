import org.scalatest.FlatSpec

class Challenge372 extends FlatSpec {

  "Challenge 372" should "return TRUE when supplying 'xxxyyy'" in {
    assert(Challenge372Easy.recurse("xxxyyy") === true)
  }

  it should "return TRUE when supplying 'yyyxxx'" in {
    assert(Challenge372Easy.recurse("yyyxxx") === true)
  }

  it should "return TRUE when supplying 'yyxyxxyxxyyyyxxxyxyx'" in {
    assert(Challenge372Easy.recurse("yyxyxxyxxyyyyxxxyxyx") === true)
  }

  it should "return TRUE when supplying ' '" in {
    assert(Challenge372Easy.recurse("") === true)
  }

  it should "return FALSE when supplying 'xxxyyyy'" in {
    assert(Challenge372Easy.recurse("xxxyyyy") === false)
  }

  it should "return FALSE when supplying 'xyxxxxyyyxyxxyxxyy'" in {
    assert(Challenge372Easy.recurse("xyxxxxyyyxyxxyxxyy") === false)
  }

  it should "return FALSE when supplying 'x'" in {
    assert(Challenge372Easy.recurse("x") === false)
  }

}
