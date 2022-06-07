package string;

import org.junit.Test;

/**
 * leetcode 541
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-30 8:34
 */
public class ReverseString_II {
    public String reverseStr(String s, int k) {
        if(k < 1){
            return s;
        }
        char[] chars = s.toCharArray();
        int curId = 0;
        int n = s.length();
        while(curId < n) {
            //可以反转2k个字符
            if (curId + 2 * k < n) {
                reverse(chars, curId, curId + k - 1);
                curId += 2 * k;
            } else if (curId + k < n && curId + 2 * k >= n) {
                //剩余字符大于等于k个但小于2k
                reverse(chars, curId, curId + k - 1);
                break;
            } else {
                //剩余字符不足k个
                reverse(chars, curId, n - 1);
                break;
            }
        }
        return new String(chars);

    }
    public void reverse(char[] s,int left, int right){
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    @Test
    public void test(){
        String s = "abcd";
        int k = 2;
        String s1 = reverseStr(s, k);
        System.out.println(s1);
    }
}
