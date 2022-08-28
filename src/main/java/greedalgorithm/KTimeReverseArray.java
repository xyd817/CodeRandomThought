package greedalgorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定⼀个整数数组 A，我们只能⽤以下⽅法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复
 * 这个过程 K 次。（我们可以多次选择同⼀个索引 i。）
 * 以这种⽅式修改数组后，返回数组可能的最⼤和。
 * 示例 1：
 * 输⼊：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 * 输⼊：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 * 输⼊：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]
 *
 * @author xyd
 * @create 2022-08-28 22:00
 */
public class KTimeReverseArray {
    public int largestSumAfterKNegations(int[] nums, int K) {
        Integer[] nums2 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        Arrays.sort(nums2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(o2), Math.abs(o1));
            }
        });
        System.out.println(Arrays.toString(nums2));
        for (int i = 0; i < nums.length; i++) {
            if(nums2[i] < 0 && K > 0) {
                nums2[i] *= -1;
                K--;
            }
        }
        System.out.println(K);
        if( K % 2 == 1) {
            nums2[nums.length - 1] *= -1;
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums2[i];
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {2, -3, -1, 5, -4};
        System.out.println(largestSumAfterKNegations(nums, 2));

    }
}
