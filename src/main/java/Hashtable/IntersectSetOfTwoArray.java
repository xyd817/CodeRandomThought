package Hashtable;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 *leetcode 349
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 *
 * @author xyd
 * @create 2022-05-25 8:55
 */
public class IntersectSetOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> ans = new HashSet<>();
        for (int num : nums2) {
            if(set.contains(num)){
                ans.add(num);
            }
        }
        Integer[] arr = ans.toArray(new Integer[ans.size()]);
        return Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
    }

    @Test
    public void test(){

        int[] nums1 = {1,2,2,1 }, nums2 = {2,2};
        int[] ans = intersection(nums1, nums2);
        for (int num : ans) {
            System.out.print(num + "  ");
        }
    }
}
