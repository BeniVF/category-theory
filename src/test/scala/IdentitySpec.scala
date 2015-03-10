import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class IdentitySpec extends FlatSpec {
  import composition._

  it should "returns back its argument" in {
    id(1) shouldBe 1
    id("Hello") shouldBe "Hello"
    id(1.4) shouldBe 1.4
  }


  it should "compose two functions" in {
    def first = (x: Double) => (x + 1).toInt
    def second = (x: Int) => (x / 2).toString

    val secondAfterFirst = composition(first, second)

    secondAfterFirst(1) shouldBe "1"

    val toCharArrayAfterComposition = composition(secondAfterFirst, (x: String) => x.toCharArray)

    toCharArrayAfterComposition(19) shouldBe Seq('1', '0')
  }

}
