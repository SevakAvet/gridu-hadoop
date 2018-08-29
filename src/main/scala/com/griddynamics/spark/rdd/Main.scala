package com.griddynamics.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by savetisyan on 15/01/2018
  */
object Main extends App {
    val conf = new SparkConf().setMaster("local[*]").setAppName("SparkHadoop")
    val sc = new SparkContext(conf)
    sc.hadoopConfiguration.set("mapreduce.input.fileinputformat.input.dir.recursive", "true")

    val events = sc.textFile("/user/savetisyan/events/*/*")
        .map(line => line.split(","))

    // only ipv4 file was used during data-generation
    val blocks = sc.textFile("/user/savetisyan/geolite/blocks/*")
        .map(x => x.split(","))
        .filter(x => !x(0).equals("network"))
        .map(x => (x(0), x(1)))

    // but we have to look into all location files, not only *-en
    val locations = sc.textFile("/user/savetisyan/geolite/locations/*")
        .map(x => x.split(","))
        .filter(x => !x(0).equals("geoname_id"))
        .map(x => (x(0), x(5)))

    val top10Categories = events.map { line => (line(4), 1) }
        .reduceByKey(_+_)
//        .map { case (category, count) => (count, category) }
        .map (_.swap)
        .sortByKey(ascending = false)
        .take(10)

    println("\nTop10 categories:")
    top10Categories.foreach(category => println("%s (%d)".format(category._2, category._1)))

    val top10Items = events.map(line => ((line(4), line(2)), 1))
        .reduceByKey(_+_)
        .map(x => (x._1._1, (x._1._2, x._2)))
        .groupByKey()
        .map(rdd => {
            val sorted = rdd._2.toList.sortBy(e => -e._2).take(10)
            (rdd._1, sorted)
        }).sortByKey()

    println("\nTop10 items in each category:")
    top10Items.foreach(rdd => {
        rdd._2.foreach(item => {
            println("%s %s %d".format(rdd._1, item._1, item._2))
        })
    })

    val eventsIp = events.map(event => (event(5), event(3).toDouble))
    eventsIp
        .join(blocks)
        .map(x => (x._2._2, x._2._1))
        .join(locations)
        .map(x => (x._2._2, x._2._1))
        .reduceByKey(_ + _)
//        .map { case (country, price) => (price, country) }
        .map (_.swap)
        .sortByKey(ascending = false)
        .take(10)
        .foreach(event => println(event))
}
