package spark.RDD编程._03转化算子._1value

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author: shade
 * @date: 2022/5/10 17:24
 * @description:
 */
object _01_Map {
  def main(args: Array[String]): Unit = {
    // 1.创建sc的配置对象
    // 如果使用yarn-client模式  master可以local[*]
    // 如果使用yarn-cluster模式  master留空
    val conf: SparkConf = new SparkConf().setAppName("sparkCore").setMaster("local[*]")

    // 2. 创建sc对象
    val sc = new SparkContext(conf)

    // 3. 编写任务代码
    val value: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6),3)

    //map
    val value1 = value.map(_ * 2)
    value1.collect().foreach(println)

    //mapPartitions
    val value2 = value.mapPartitions(it => it.map(_ * 2))
    value2.collect().foreach(println)

    //mapPartitionsWithIndex
    val value3 = value.mapPartitionsWithIndex((id, it) => it.map(a => (id, a * 2)))
    value3.collect().foreach(println)

    // 4.关闭sc
    sc.stop()
  }
}
