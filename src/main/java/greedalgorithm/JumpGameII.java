package greedalgorithm;

import org.junit.Test;

/**
 * 给定⼀个⾮负整数数组，你最初位于数组的第⼀个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最⼤⻓度。
 * 你的⽬标是使⽤最少的跳跃次数到达数组的最后⼀个位置。
 * 示例:
 * 输⼊: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后⼀个位置的最⼩跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最
 * 后⼀个位置。
 * 说明:
 * 假设你总是可以到达数组的最后⼀个位置。
 *
 * @author xyd
 * @create 2022-08-28 8:07
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int curDistance = 0; // 当前的覆盖范围
        int ans = 0; // 跳跃到终点的步数
        int nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance, i + nums[i]);
            if (curDistance != nums.length - 1) {
                ans++;
                curDistance = nextDistance;
                if (nextDistance >= nums.length - 1) {
                    break;
                }
            } else {
                break;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
