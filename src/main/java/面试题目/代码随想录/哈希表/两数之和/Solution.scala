package 面试题目.代码随想录.哈希表.两数之和

import scala.collection.mutable


/**
 * @author: shade
 * @date: 2022/5/8 11:57
 * @description:
 */
object Solution2 {
  def main(args: Array[String]): Unit = {
    println(twoSum(Array[Int](1, 2, 3, 4, 5, 6, 7), 3).mkString("\t"))

  }

  def twoSum(ints: Array[Int], target: Int) = {
    val array = new Array[Int](2)
    val map = mutable.Map[Int, Int]()
    for (i <- ints.indices) {
      val num = ints(i)
      if (!map.contains(target - num)) {
        map.put(num, i)
      } else {
        array(0) = map.getOrElse(target - num, -1)
        array(1) = i
      }
    }
    array
  }
}
