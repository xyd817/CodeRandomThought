package AboutArray

/**
 * leetcode 209
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-05-19 10:17
 */
object ShortestSubarray {
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
    //使用滑动窗口的方法
    var left: Int = 0 //窗口最左端的下标
    var curSum: Int = 0 // 当前窗口总和
    val n: Int = nums.length
    var ans: Int = Int.MaxValue //结果值
    for (i <- 0 until n) {
      curSum += nums(i)
      //缩小窗口
      while (curSum >= target) {
        //更新结果值
        ans = Math.min(ans, i - left + 1)
        curSum -= nums(left)
        left += 1
      }
    }
    if (ans == Int.MaxValue) 0 else ans
  }

  def main(args: Array[String]): Unit = {
    val target = 7
    val nums = Array(2, 3, 1, 2, 4, 3)

    println(minSubArrayLen(target, nums))
  }
}
