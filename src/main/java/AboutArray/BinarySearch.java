package AboutArray;

import java.util.Scanner;

/**
 *leetcode:704题
 * 给定一个n 元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-18 10:00
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        if(nums == null){
            return -1;
        }
        //使用二分查找的方法来实现
        int left = 0, right = nums.length - 1;
        int res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                res = mid;
                break;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int n = scan.nextInt();
        System.out.println();
        int[] nums = new int[n];
        System.out.println("请输入数组元素：");
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println("请输入目标值:");
        int target = scan.nextInt();
        System.out.print("结果：");
        BinarySearch bSearch = new BinarySearch();
        int ans = bSearch.search(nums,target);
        System.out.println(ans);
    }
}

