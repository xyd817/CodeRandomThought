package string;

import org.junit.Test;

import java.util.Collections;

/**
 * Offer 05
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @author xyd
 * @create 2022-05-30 9:02
 */
public class ReplaceBlank {
    public String replaceSpace(String s) {
        int n = s.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if(' ' == s.charAt(i)){
                ans.append("%20");
            }else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
    @Test
    public void test(){
        String s = "hello world  ";
        System.out.println(replaceSpace(s));
    }
}
