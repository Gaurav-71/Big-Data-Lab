case class CaseClassExample(v1: String, v2: String)

object Test {
  def main(args: Array[String]) : Unit = {
    val caseClassExampleTest = CaseClassExample("abc", "def")

    println(caseClassExampleTest.v1)
    println(caseClassExampleTest.v2)
  }
}
