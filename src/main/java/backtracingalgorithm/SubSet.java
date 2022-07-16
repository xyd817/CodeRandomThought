package backtracingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 78
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author xyd
 * @create 2022-07-16 10:09
 */
public class SubSet {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backtracing(int[] nums, int start) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //选择当前元素
        path.add(nums[start]);
        backtracing(nums, start + 1);
        path.remove(path.size() - 1);
        //不选择当前元素
        backtracing(nums, start + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtracing(nums, 0);
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
