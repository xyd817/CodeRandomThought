package Hashtable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 18
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a],
 * nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-29 9:32
 */
public class FourNumberSum_2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            //去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                //去重
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int left = j + 1, right = n - 1;
                while(left < right){
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if(temp == target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //去重
                        right--;
                        while(left < right && nums[right] == nums[right+1]) right--;
                        left++;
                        while (left < right && nums[left] == nums[left-1]) left++;
                    }else if(temp > target){
                        right--;
                        while(left < right && nums[right] == nums[right+1]) right--;

                    }else{
                        left++;
                        while (left < right && nums[left] == nums[left-1]) left++;

                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){

        int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;

        List<List<Integer>> lists = fourSum(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }
}
