package com.zoma.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;

import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class WordCountJob {
    public static void main(String[] args) {
        // Configuration Spark
        SparkConf conf = new SparkConf().setAppName("Word Count Job").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Données brutes à traiter
        String text = "hello spark hello python hello thierros hello airflow hello docker hello postgres and hello git";

        // Paralleliser les données
        JavaRDD<String> lines = sc.parallelize(Arrays.asList(text.split(" ")));

        // Compter les mots
        JavaPairRDD<String, Integer> counts = lines
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey(Integer::sum);

        // Collecter et afficher le résultat
        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<String, Integer> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }

        // Fermer le contexte
        sc.close();
    }
}
