package spark.RDD编程._02分区规则

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author: shade
 * @date: 2022/5/10 17:17
 * @description:
 */
object File_Partition {
  def main(args: Array[String]): Unit = {
    // 1.创建sc的配置对象
    // 如果使用yarn-client模式  master可以local[*]
    // 如果使用yarn-cluster模式  master留空
    val conf: SparkConf = new SparkConf().setAppName("sparkCore").setMaster("local[*]")

    // 2. 创建sc对象
    val sc = new SparkContext(conf)

    // 3. 编写任务代码
    // 默认填写的最小分区数   2和环境的核数取小的值  一般为2
    // math.min(defaultParallelism, 2)
    val lineRDD: RDD[String] = sc.textFile("input/1.txt", 3)
    /**
     * 具体的分区个数需要经过公式计算
     * 首先获取文件的总长度  totalSize
     * 计算平均长度  goalSize = totalSize / numSplits
     * 获取块大小 128M
     * 计算切分大小  splitSize = Math.max(minSize, Math.min(goalSize, blockSize));
     * 最后使用splitSize  按照1.1倍原则切分整个文件   得到几个分区就是几个分区
     * 实际开发中   只需要看文件总大小 / 填写的分区数  和块大小比较  谁小拿谁进行切分
     */
    lineRDD.saveAsTextFile("output")

    /**
     * 数据会分配到哪个分区
     * 如果切分的位置位于一行的中间  会在当前分区读完一整行数据
     * 分配区间左闭右闭 2个区间右公共的一个数据
     */

    // 4.关闭sc
    sc.stop()
  }
}
