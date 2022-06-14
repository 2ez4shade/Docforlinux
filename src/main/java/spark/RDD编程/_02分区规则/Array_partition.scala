package spark.RDD编程._02分区规则

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author: shade
 * @date: 2022/5/10 17:13
 * @description: 集合的分区规则 以及执行时如何分区
 */
object Array_partition {
  def main(args: Array[String]): Unit = {
    // 1.创建sc的配置对象
    // 如果使用yarn-client模式  master可以local[*]
    // 如果使用yarn-cluster模式  master留空
    val conf: SparkConf = new SparkConf().setAppName("sparkCore").setMaster("local[*]")

    // 2. 创建sc对象
    val sc = new SparkContext(conf)

    // 3. 编写任务代码
    // 默认环境的核数
    // 可以手动填写参数控制分区的个数
    val intRDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5), 2)

    /**
     * 数据分区的情况
     * 0 => 1,2  1 => 3,4,5
     * RDD的五大特性   getPartitions
     * 利用整数除机制  左闭右开
     * 0 => start 0*5/2  end 1*5/2
     * 1 => start 1*5/2  end 2*5/2
     */

    // 将rdd保存到文件  有几个文件生成  就有几个分区
    intRDD.saveAsTextFile("output")

    // 4.关闭sc
    sc.stop()
  }
}
