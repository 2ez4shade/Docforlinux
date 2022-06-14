package spark.RDD编程._04实战

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author: shade
 * @date: 2022/6/3 16:32
 * @description:
 */
object top10_01 {
  def main(args: Array[String]): Unit = {
    // 1.创建sc的配置对象
    // 如果使用yarn-client模式  master可以local[*]
    // 如果使用yarn-cluster模式  master留空
    val conf: SparkConf = new SparkConf().setAppName("sparkCore").setMaster("local[*]")

    // 2. 创建sc对象
    val sc = new SparkContext(conf)

    // 3. 编写任务代码
    val lineRDD: RDD[String] = sc.textFile("C:\\x99pro\\develop\\Code\\Docforlinux\\input\\user_visit_action.txt")

    val tupleRDD: RDD[(String, (Int, Int, Int))] = lineRDD.flatMap(line => {
      val strings: Array[String] = line.split("_")
      if (strings(6) != "-1") {
        List((strings(6), (1, 0, 0)))
      } else if (strings(8) != "null") {
        strings(8).split(",").map((_, (0, 1, 0)))
      } else if (strings(10) != "null") {
        strings(10).split(",").map((_, (0, 0, 1)))
      } else {
        Nil
      }
    })

    val reduceRDD: RDD[(String, (Int, Int, Int))] = tupleRDD.reduceByKey((a, b) => {
      (a._1 + b._1, a._2 + b._2, a._3 + b._3)
    })

    val array: Array[(String, (Int, Int, Int))] = reduceRDD.sortBy(_._2, false).take(10)

    array.foreach(println)



    // 4.关闭sc
    sc.stop()
  }
}
