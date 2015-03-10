import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class CompositionSpec extends FlatSpec {
  import composition._

  "id function" should "returns back its argument" in {
    id(1) shouldBe 1
    id("Hello") shouldBe "Hello"
    id(1.4) shouldBe 1.4
  }


  "composition" should "compose two functions" in {
    val first = (x: Double) => (x + 1).toInt
    val second = (x: Int) => (x / 2).toString

    val secondAfterFirst = composition(first, second)

    secondAfterFirst(1) shouldBe "1"

    val toCharArrayAfterComposition = composition(secondAfterFirst, (x: String) => x.toCharArray)

    toCharArrayAfterComposition(19) shouldBe Seq('1', '0')
  }


  it should "respects identity" in {
    val myFunction = (x: Int) => (x*x).toString
    val idAfterMyFunction = composition(myFunction, id[String])
    val myFunctionAfterId = composition(id[Int], myFunction)


    idAfterMyFunction(100) shouldBe myFunction(100)
    myFunctionAfterId(1000) shouldBe myFunction(1000)

  }

}
