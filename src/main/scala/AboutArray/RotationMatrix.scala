package AboutArray

/**
 *leetcode 59
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @author xyd
 * @create 2022-05-20 10:13
 */
object RotationMatrix {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    //循环次数
    var loop:Int = n / 2
    //每次循环开始和结束的位置
    var (startX, startY) = (0, 0)
    //循环减少量
    var offset = 1
    //循环打印的数字
    var num = 1
    val matrix = Array.ofDim[Int](n,n)
    while(loop > 0){
      //模拟从左到右打印
      var (x,y) = (startX, startY)
      for(j <- x until x + n - offset){
        matrix(x)(j) = num
        num += 1
      }
      //模拟从上到下打印
      for(i <- x until x + n - offset){
        matrix(i)(x + n - offset) = num
        num += 1
      }
      //模拟从右往左打印
      for(j <- x + n - offset until y by -1){
        matrix(x + n - offset)(j) = num
        num += 1
      }
      //模拟从下往上打印
      for(i <- x + n - offset until x by -1){
        matrix(i)(y) = num
        num += 1
      }
      loop  -= 1
      startX += 1
      startY += 1
      offset += 2
    }
    //n为奇数，填上最后一个数字
    if(n % 2 == 1){
      matrix(startX)(startY) = num
    }
    matrix
  }

  def main(args: Array[String]): Unit = {
    val n = 1
    val matrix = generateMatrix(n)
    for(i <- matrix.indices ; j <- matrix(i).indices){
      print(matrix(i)(j) + " ")
      if( j == matrix(i).length - 1) {
        println()
      }
    }

  }
}
