package backtracingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 47
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * @author xyd
 * @create 2022-07-18 11:57
 */
public class PermuteII {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backtracing(int[] nums, boolean[] visited) {
        if (nums.length == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) || visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtracing(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracing(nums, visited);
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}
