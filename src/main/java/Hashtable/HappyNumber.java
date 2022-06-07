package Hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 202
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-26 9:13
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        boolean flag = false;
        while (true){
            int sum = 0;
            while(n > 0){
                int num = n % 10;
                sum += num * num;
                n /= 10;
            }
            n = sum;
            if(sum == 1){
                flag = true;
                break;
            }
            if(set.contains(sum)){
                flag = false;
                break;
            }
            set.add(sum);
        }
        return flag;
    }
    @Test
    public void test(){
        int n = 2;
        System.out.println(isHappy(n));
    }

}
