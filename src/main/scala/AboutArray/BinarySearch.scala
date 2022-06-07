package AboutArray

import scala.io.StdIn
import scala.util.control.Breaks

/**
 * leetcode:704
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-05-18 10:04
 */
class Solution {
  def search(nums: Array[Int], target: Int): Int = {
    if (nums == null) {
      return -1
    }
    var left = 0
    var right = nums.length - 1
    var res = -1
    Breaks.breakable(
      while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums(mid) == target) {
          res = mid;
          Breaks.break()
        } else if (nums(mid) < target) {
          left = mid + 1
        } else {
          right = mid - 1
        }
      }
    )
    res
  }
}
object Other{
  def main(args: Array[String]): Unit = {
    val n: Int = StdIn.readInt()
    val nums: Array[Int] = new Array(n)
    for (i <- 0 until n) {
      nums(i) = StdIn.readInt()
    }
    val taregt = StdIn.readInt()
    val obj = new Solution()
    println(obj.search(nums, taregt))
  }
}
