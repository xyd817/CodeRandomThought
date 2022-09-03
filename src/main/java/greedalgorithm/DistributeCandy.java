package greedalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * ⽼师想给孩⼦们分发糖果，有 N 个孩⼦站成了⼀条直线，⽼师会根据每个孩⼦的表现，预先给他们评分。
 * 你需要按照以下要求，帮助⽼师给这些孩⼦分发糖果：
 * 那么这样下来，⽼师⾄少需要准备多少颗糖果呢？
 * 示例 1:
 * 输⼊: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩⼦分发 2、1、2 颗糖果。
 * 示例 2:
 * 输⼊: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩⼦分发 1、2、1 颗糖果。
 * 第三个孩⼦只得到 1 颗糖果，这已满⾜上述两个条件。
 *
 * @author xyd
 * @create 2022-09-02 7:27
 */
public class DistributeCandy {
    public int candy(int[] nums) {
        int[] candyDev = new int[nums.length];
        Arrays.fill(candyDev, 1);
        // 从左往右遍历，保证右边的孩子的分数比左边的孩子分数高时右边孩子分的糖果更多
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                candyDev[i] = candyDev[i - 1] + 1;
            }
        }
        // 从右往左遍历，保证左边孩子分数比右边孩子分数高时，左边孩子获得更高的糖果
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                candyDev[i] = Math.max(candyDev[i + 1] + 1, candyDev[i]);
            }
        }
        return Arrays.stream(candyDev).sum();
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 2};
        System.out.println(candy(nums));
    }
}
