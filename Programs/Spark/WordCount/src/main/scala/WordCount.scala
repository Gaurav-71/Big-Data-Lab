import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD

object WordCount {
  def main(args: Array[String]) {
    val file = "src/main/words.txt"
    val spark: SparkSession = SparkSession.builder
      .appName("Word Count")
      .config("spark.master", "local")
      .getOrCreate()
    val fileRdd: RDD[String] = spark.sparkContext.textFile(file)

    // create the counts
    val counts = fileRdd.map(_.replaceAll("[.,]", ""))
      .map(_.replace("—", " "))
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
      .sortBy(_._2)
      .collect

    println( "------------------------------------------")
    counts.foreach(println)
    println( "------------------------------------------")

    spark.stop()
  }

}