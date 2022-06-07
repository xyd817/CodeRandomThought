package string;

import org.junit.Test;

/**
 *Offer 58
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @author xyd
 * @create 2022-06-01 9:41
 */
public class LeftRotateString {
    public String reverseLeftWords(String s, int n) {
        if(n <= 0 || n > s.length()){
            return s;
        }
        char[] chars = s.toCharArray();
        swap(chars,0,n - 1);
        swap(chars,n,s.length() - 1);
        swap(chars,0,s.length() - 1);
        return new String(chars);
    }
    public void swap(char[] chars,int start, int end){
        while(start < end){
            chars[start] ^= chars[end];
            chars[end] ^= chars[start];
            chars[start] ^= chars[end];
            start++;
            end--;
        }
    }
    @Test
    public void test(){
        String s = "abcdefg";
        int k  = 2;
        System.out.println(reverseLeftWords(s,k));
    }
}
