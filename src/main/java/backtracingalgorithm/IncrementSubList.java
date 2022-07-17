package backtracingalgorithm;

import org.junit.Test;

import java.util.*;

/**
 * leetcode 491
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-07-17 11:55
 */
public class IncrementSubList {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] set = new int[201];
    private void backtracing(int[] nums, int start){
        if(path.size() > 1){
            ans.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start ; i < nums.length ; i++) {
            if((!path.isEmpty() && nums[i] < path.get(path.size() - 1)) || set.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backtracing(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null){
            return ans;
        }
        Arrays.fill(set, 0);
        backtracing(nums, 0 );
        return ans;
    }
    @Test
    public void test(){
        int[] nums = { 4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }
}
