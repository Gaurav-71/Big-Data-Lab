import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object TransformationFunctions extends App {
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
  //show all
  df.select("*").show(truncate = false)

  //first row
  df.select(first("salary")).show(false)

  //last row
  df.select(last("salary")).show(false)

  //Select first 2 columns.
  df.select(df.columns.slice(0,2).map(m=>col(m)):_*).show()


  //Selects 3rd column (index starts from zero)
  df.select(df.columns(2)).show()

  //Selects columns from index 1 to 3
  df.select(df.columns.slice(1,3).map(m=>col(m)):_*).show()

}
