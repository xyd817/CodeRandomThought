package Hashtable;

import org.junit.Test;

import java.util.*;

/**
 * leetcode 15
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-05-28 10:59
 */
public class ThreeNumberSum {
    //使用Hash表的方法
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        // a = nums[i], b = nums[j] , c 在nums[i]和nums[j]之间
        for (int i = 0; i < n; i++) {
            //第一个元素大于0，直接跳过
            if(nums[i] > 0){
                continue;
            }
            //对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                //对b进行去重
                if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
                    continue;
                }
                int c = -(nums[i] + nums[j]);
                if (!set.isEmpty() && set.contains(c)) {

                    ans.add(Arrays.asList(nums[i],nums[j],c));
                    //对c去重
                    set.remove(c);
                }else{
                    set.add(nums[j]);
                }
            }
        }
        return ans;
    }
    //使用双指针的方法
    public List<List<Integer>> threeSum1(int[] nums){
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if(nums[i] > 0){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //使用双指针
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    //right往左移
                    right--;
                    while(right > left && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    //left往右移动
                    left++;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                }else{
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //去重
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(right > left && nums[right] == nums[right -1]){
                        right--;
                    }
                    //同时收缩指针
                    left++;
                    right--;
                }
            }

        }
        return ans;
    }


    @Test
    public void test(){
        int[] nums = {0,0,0,0};
        List<List<Integer>> lists = threeSum1(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }



}
