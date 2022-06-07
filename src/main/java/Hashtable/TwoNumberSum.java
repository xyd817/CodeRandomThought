package Hashtable;

import org.junit.Test;

import java.util.*;

/**
 *leetcode 1
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，
 * 并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-26 9:44
 */
public class TwoNumberSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return null;
        }
        int[] ans = new int[2];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < nums.length;i++) {
            Set set = map.getOrDefault(nums[i], new HashSet<>());
            set.add(i);
            map.put(nums[i],set);
            int delta = target - nums[i];
            if(map.containsKey(delta)){
                Set<Integer> ids = map.get(delta);
                for (Integer id : ids) {
                    if(id != i){
                        ans[0] = i;
                        ans[1] = id;
                        return ans;
                    }
                }
             }
        }

        return ans;

    }
    @Test
    public void test(){
        int[] nums = {3,3};
        int target = 6;
        int[] ans = twoSum(nums, target);
        System.out.println(ans[0] + ", " + ans[1]);

    }
}
