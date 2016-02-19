package org.leocook.spark.spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * Created by MX-Test11 on 2016/2/18.
 */
object SocketStreaming {
  def main(args: Array[String]) {

    System.setProperty("hadoop.home.dir", "C:\\hadoop-2.6.0-cdh5.4.4")
    System.setProperty("HADOOP_USER_NAME", "wulin")

    val sparkConf = new SparkConf().setAppName("SocketStreaming").setMaster("local[*]")

    val ssc = new StreamingContext(sparkConf, Seconds(1))

    val line = ssc.socketTextStream("localhost",7777)

    line.filter(!_.contains("bye")).print()

    ssc.start()
    ssc.awaitTermination()
  }
}
