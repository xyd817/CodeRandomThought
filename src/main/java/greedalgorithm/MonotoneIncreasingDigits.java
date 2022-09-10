package greedalgorithm;

import org.junit.Test;

/**
 * 当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-09-10 17:31
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int start = chars.length;
        for (int i = chars.length - 2; i >= 0 ; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

    @Test
    public void test() {
        int n = 100;
        System.out.println(monotoneIncreasingDigits(n));
    }

}
