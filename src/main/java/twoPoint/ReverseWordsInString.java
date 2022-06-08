package twoPoint;

import org.junit.Test;

/**
 * leetcode 151
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-06-08 8:32
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        if ("".equals(s)) {
            return s;
        }
        char[] chars = s.toCharArray();
        //先将整个字符串反转
        int n = s.length();
        reverse(chars, 0, n - 1);
        int k = 0, i = 0;
        while (i < n) {
            if (' ' == chars[i]) {
                i++;
                continue;
            }
            int startId = i;
            //寻找单词末尾
            while(i < n && ' ' != chars[i]){
                i++;
            }
            //反转该单词，并交换到数组开头，挤掉多余的空格
            for (int j = startId; j < i; j++) {
                if(j == startId){
                    reverse(chars,startId,i - 1);
                }
                chars[k++] = chars[j];
                //单词末尾，增加一个空格
                if(j == i - 1){
                    if(k != n ){
                        chars[k++] = ' ';
                    }
                }

            }
        }
        return new String(chars,0,k == n && chars[k - 1] != ' ' ? k : k - 1);

    }

    //反转字符数组中的[start,end]间的字符
    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];
            start++;
            end--;
        }
    }

    @Test
    public void test(){
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
