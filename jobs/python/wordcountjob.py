from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("PythonWordCount").getOrCreate()

text = "hello spark hello python hello thierros hello airflow hello docker hello postgres and hello git"

words = spark.sparkContext.parallelize(text.split(" "))

wordCount = words.map(lambda word: (word, 1)).reduceByKey(lambda a, b: a + b)

for wc in wordCount.collect():
    print(wc[0], wc[1])

spark.stop()