package AboutArray

/**
 * leetcode 27:
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-05-18 11:34
 */

object Other1 {
  def main(args: Array[String]): Unit = {
    val obj = new Solution1()
    val nums = Array(3, 2, 2, 3, 4)
    val target = 3
    val len: Int = obj.removeElement(nums, target)
    for (i <- 0 until len) {
      println(nums(i))
    }
  }
}
class Solution1 {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    if (nums == null) {
      -1
    }
    var left = 0
    var right = nums.length - 1
    while (left <= right) {
      //寻找左边第一个w为val的元素位置
      while (left <= right && nums(left) != `val`) {
        left += 1
      }
      //寻找右边第一个不为val的元素位置
      while (left <= right && nums(right) == `val`) {
        right -= 1
      }
      //交换左边为val和右边不为val的元素位置
      if (left < right) {
        nums(left) = nums(right)
        left += 1
        right -= 1
      }
    }
    left
  }
}
