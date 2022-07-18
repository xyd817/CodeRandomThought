package backtracingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 46
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @author xyd
 * @create 2022-07-18 11:41
 */
public class Permute {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backtracing(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                backtracing(nums, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        backtracing(nums, visit);
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
