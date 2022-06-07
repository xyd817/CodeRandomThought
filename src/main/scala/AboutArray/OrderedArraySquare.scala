package AboutArray

/**
 * leetcode 977
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * @author xyd
 * @create 2022-05-19 9:38
 */
object OrderedArraySquare {
  def sortedSquares(nums: Array[Int]): Array[Int] = {
    //使用双指针的方法:
    //因为数组有序，可以使用双指针从数组两端每次得到一个大的平方数
    //然后按从大到小的顺序放在另一个数组即可
    val n: Int = nums.length
    val ans: Array[Int] = new Array[Int](n)
    var (left: Int, right: Int) = (0, n - 1)
    var id: Int = n - 1
    while (left <= right) {
      if (nums(left) * nums(left) < nums(right) * nums(right)) {
        ans(id) = nums(right) * nums(right)
        right -= 1
      } else {
        ans(id) = nums(left) * nums(left)
        left += 1
      }
      id -= 1
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(-4, -1, 0, 3, 10)
    val res: Array[Int] = sortedSquares(nums)
    println(res.mkString(","))
  }
}
