package greedalgorithm;

import org.junit.Test;

/**
 * leetcode 55
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * @author xyd
 * @create 2022-07-24 4:36
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            if(nums[i] + i > cover){
                cover = nums[i] + i;
            }
            if(cover >= nums.length - 1){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        //int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
