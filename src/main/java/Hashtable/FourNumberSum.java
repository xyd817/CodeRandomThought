package Hashtable;

import org.junit.Test;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode 454
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-27 9:17
 */
public class FourNumberSum {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if(nums1 == null || nums2 == null || nums3 == null || nums4 == null){
            return 0;
        }
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int keyValue = map1.getOrDefault(nums1[i] + nums2[j], 0) + 1;
                map1.put(nums1[i] + nums2[j], keyValue);
            }
        }
        int ans = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
               int temp = -(nums3[i] + nums4[j]);
               ans += map1.getOrDefault(temp, 0);
            }
        }
        return ans;
    }

    @Test
    public void test(){

        int[] nums1 = {0,1,-1}, nums2 = {-1,1,0}, nums3 = {0,0,1}, nums4 = {-1,1,1};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }
}
