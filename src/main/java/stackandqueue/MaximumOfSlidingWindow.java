package stackandqueue;

import jdk.nashorn.internal.ir.IdentNode;
import org.junit.Test;

import java.util.*;

/**
 * leetcode 239
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-06-13 9:24
 */
public class MaximumOfSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            //弹出队列中不在当前窗口的值
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            //压入当前元素所在的下标值
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.peek()];
            }
        }
        return ans;

    }

    @Test
    public void test() {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
