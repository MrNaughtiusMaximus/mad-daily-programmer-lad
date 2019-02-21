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

  "Challenge 372 Bonus" should "return TRUE when supplying 'xxxyyyzzz'" in {
    assert(Challenge372Easy.check("xxxyyyzzz") === true)
  }

  it should "return TRUE when supplying 'abccbaabccba'" in {
    assert(Challenge372Easy.check("abccbaabccba") === true)
  }

  it should "return TRUE when supplying 'abcdefghijklmnopqrstuvwxyz'" in {
    assert(Challenge372Easy.check("abcdefghijklmnopqrstuvwxyz") === true)
  }

  it should "return TRUE when supplying 'www'" in {
    assert(Challenge372Easy.check("www") === true)
  }

  it should "return TRUE when supplying 'x'" in {
    assert(Challenge372Easy.check("x") === true)
  }

  it should "return TRUE when supplying ''" in {
    assert(Challenge372Easy.check("") === true)
  }

  it should "return FALSE when supplying 'xxxyyyzzzz'" in {
    assert(Challenge372Easy.check("xxxyyyzzzz") === false)
  }

  it should "return FALSE when supplying 'pqq'" in {
    assert(Challenge372Easy.check("pqq") === false)
  }

  it should "return FALSE when supplying 'fdedfdeffeddefeeeefddf'" in {
    assert(Challenge372Easy.check("fdedfdeffeddefeeeefddf") === false)
  }

}
