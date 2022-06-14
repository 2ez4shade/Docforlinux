package spark.RDD编程._01RDD创建

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author: shade
 * @date: 2022/5/10 17:02
 * @description:
 */
object RDDCreate {
  def main(args: Array[String]): Unit = {
    // 1.创建sc的配置对象
    // 如果使用yarn-client模式  master可以local[*]
    // 如果使用yarn-cluster模式  master留空
    val conf: SparkConf = new SparkConf()
      .setAppName("sparkCore").setMaster("local[*]")

    // 2. 创建sc对象
    val sc = new SparkContext(conf)

    // 3. 编写任务代码
    val list = List(1, 2, 3, 4)

    // 从集合创建rdd
    val intRDD: RDD[Int] = sc.parallelize(list)
    intRDD.collect().foreach(println)

    // 底层调用parallelize   推荐使用  比较好记
    val intRDD1: RDD[Int] = sc.makeRDD(list)
    intRDD1.collect().foreach(println)

    //从外部存储系统的数据集创建
    val value: RDD[String] = sc.textFile("外部储存系统")
     value.collect().foreach(println)

    // 4.关闭sc
    sc.stop()

  }
}
