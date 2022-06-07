package twoPoint;

import org.junit.Test;

/**
 * leetcode 05
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @author xyd
 * @create 2022-06-07 9:34
 */
public class ReplaceBlank {
    public String replaceSpace(String s) {
        //使用双指针的方法来决解
        if("".equals(s)){
            return s;
        }
        //统计空格的数量
        int n = s.length(), cnt = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == ' '){
                cnt++;
            }
        }
        //没有空格，直接返回
        if(cnt == 0){
            return s;
        }
        char[] chars = new char[n + 2* cnt];
        int left = n - 1 ,right = n + 2 * cnt - 1;
        while(left >= 0){
            if(s.charAt(left) == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right--] = '%';
                left--;
            }else{
                chars[right--] = s.charAt(left--);
            }
        }
        return new String(chars);
    }
    @Test
    public void test(){
        String s = "  We are happy.";
        System.out.println(replaceSpace(s));
    }
}
