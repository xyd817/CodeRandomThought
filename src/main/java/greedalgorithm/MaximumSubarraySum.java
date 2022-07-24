package greedalgorithm;

import org.junit.Test;

/**
 * leetcode 53
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 *
 * @author xyd
 * @create 2022-07-24 2:15
 */
public class MaximumSubarraySum {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (ans < count) {
                ans = count;
            }
            if (count <= 0) {
                count = 0;
            }
        }
        return ans;
    }
    //动态规划的解法
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1]+ nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray1(nums));
    }
}
