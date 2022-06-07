package string;

import org.junit.Test;

/**
 * leetcode  459
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 * @author xyd
 * @create 2022-06-06 8:39
 */
public class RepeatSubstring {
    //创建next数组
    public int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < n; i++) {
            //前后缀不相等
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            //前后缀相等
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public boolean repeatedSubstringPattern(String s) {
        if ("".equals(s)) {
            return false;
        }
        int[] next = getNext(s);
        int len = next.length;
        if(next[len - 1] != -1 && len % ( len - (next[len - 1] + 1)) == 0 ){
            return true;
        }
        return false;

    }

    @Test
    public void test() {
        String s = "aba";
        System.out.println(repeatedSubstringPattern(s));
    }
}
