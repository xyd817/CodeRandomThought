package AboutArray;

import org.junit.Test;

/**
 * leetcode:27题
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-18 10:56
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null){
            return -1;
        }
        int slow = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] != val){
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }
    @Test
    public void test(){
        int[] nums = {2,3,2,3,4};
        int val = 3;
        int len = removeElement(nums,val);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
