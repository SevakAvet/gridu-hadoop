package com.griddynamics.spark.dataset

//import java.util.Properties

//import org.apache.spark.sql.types._
//import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * Created by savetisyan on 15/01/2018
  */
object Main extends App {
//    val spark = SparkSession
//        .builder()
//        .appName("Spark Hadoop Datasets")
//        .master("local[*]")
//        .getOrCreate()
//
//    import spark.implicits._
//
//    spark.sparkContext.hadoopConfiguration.set("mapreduce.input.fileinputformat.input.dir.recursive", "true")
//
//    case class Product(date: String, time: String, name: String, price: Double,
//                       category: String, ip: String)
//
//    case class Block(ip: String, geoname_id: Int)
//
//    case class Location(geoname_id: Int, country_name: String)
//
//    val customSchema = StructType(Array(
//        StructField("date", StringType, true),
//        StructField("time", StringType, true),
//        StructField("name", StringType, true),
//        StructField("price", DoubleType, true),
//        StructField("category", StringType, true),
//        StructField("ip", StringType, true)))
//
//    val products = spark.read.schema(customSchema).csv("/user/savetisyan/events/*/*/*/*").as[Product]
//
//    val dataFrameReader = spark.read.format("csv").option("header", true)
//
//    val blocksDF = dataFrameReader.load("/user/savetisyan/geolite/blocks/*")
//    val blocks = blocksDF.select(blocksDF("network").as("ip"), blocksDF("geoname_id").cast(IntegerType)).as[Block]
//
//    val locationsDF = dataFrameReader.load("/user/savetisyan/geolite/locations/*")
//    val locations = locationsDF.select(locationsDF("geoname_id").cast(IntegerType), locationsDF("country_name")).as[Location]
//
//    println("Events count " + products.count())
//    val top10Categories = products.groupByKey(x => x.category).
//        count().
//        sort($"count(1)".desc).
//        limit(10)
//
//    println("Top categories")
//    top10Categories.foreach(x => println("%s %d".format(x._1, x._2)))
//
//    var top10ItemsInCategories = products.groupByKey(product => (product.category, product.name)).
//        mapGroups((key, values) => (key, values.length)).
//        map(x => (x._1._1, (x._1._2, x._2))).
//        groupByKey(x => x._1).
//        mapGroups((key, value) =>
//            (key, value.map(x => x._2).
//                toList.
//                sortBy(x => -x._2).
//                take(10)))
//
//    println("Top10 items in each category")
//    top10ItemsInCategories.foreach(x =>
//        x._2.foreach(y =>
//            println("%s %s %d".format(x._1, y._1, y._2))))
//
//    val productsDF = products.toDF()
//    val joinDF = productsDF.
//        join(blocksDF, productsDF.col("ip") === blocksDF.col("network")).
//        join(locationsDF, locationsDF.col("geoname_id") === blocksDF.col("geoname_id"))
//
//    case class CountrySpending(name: String, spending: Double)
//
//    val topCountries = joinDF.select(joinDF("country_name").as("name"), joinDF("price").as("spending")).as[CountrySpending].
//        groupByKey(x => x.name).
//        mapGroups((key, value) => (key, value.map(x => x.spending).sum)).
//        orderBy($"_2".desc).
//        limit(10)
//
//    println("Top10 countries by money spending")
//    topCountries.foreach(println(_))
//
//    val prop = new Properties()
//    prop.setProperty("user", "root")
//    prop.setProperty("password", "hadoop")
//    val host = "localhost"
//    val database = "spark"
//
//    top10Categories.toDF().write
//        .mode(SaveMode.Overwrite)
//        .option("driver", "com.mysql.jdbc.Driver")
//        .jdbc(s"jdbc:mysql://${host}:3306/${database}", "top10categories_spark", prop)
//
//    top10ItemsInCategories
//        .flatMap(x => x._2.map(y => (x._1, y._1, y._2)))
//        .toDF()
//        .write
//        .mode(SaveMode.Overwrite)
//        .option("driver", "com.mysql.jdbc.Driver")
//        .jdbc(s"jdbc:mysql://${host}:3306/${database}", "top10items_spark", prop)
//
//    topCountries.show()
//    topCountries.printSchema()
//    topCountries.toDF().write
//        .mode(SaveMode.Overwrite)
//        .option("driver", "com.mysql.jdbc.Driver")
//        .jdbc(s"jdbc:mysql://${host}:3306/${database}", "top10countries_spark", prop)
}
