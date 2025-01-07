import org.apache.spark.sql.SparkSession

object WordCount {
    def main(args: Array[String]){
        val spark = SparkSession.builder.appName("Word Count").master("spark://spark-master:7077").getOrCreate()
        val sc = spark.sparkContext

        val textData = sc.parallelize(List("hello spark", "hello python", "hello thierros", "hello airflow", "hello docker", "hello postgres", "and hello git"))

        val counts = textData.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)

        counts.collect().foreach(println)

        spark.stop()
    }
}