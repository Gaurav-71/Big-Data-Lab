import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object MathFunctions extends App {
  val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val simpleData = Seq(("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("Scott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100)
  )
  val df = simpleData.toDF("employee_name", "department", "salary")

  df.select(max("salary")).show(false)

  df.select(min("salary")).show(false)

  df.select(mean("salary")).show(false)

  df.select(skewness("salary")).show(false)

  df.select(stddev("salary"), stddev_samp("salary"),
    stddev_pop("salary")).show(false)

  df.select(sum("salary")).show(false)

  df.select(sumDistinct("salary")).show(false)

  df.select(variance("salary"),var_samp("salary"),
    var_pop("salary")).show(false)

}
