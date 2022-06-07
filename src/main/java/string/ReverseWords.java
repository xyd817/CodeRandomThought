package string;

import org.junit.Test;

import java.io.BufferedReader;

/**
 * leetcode 151
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，
 * 单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-31 20:52
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] initArr = s.toCharArray();
        swap(initArr,0,initArr.length - 1);
        int k = 0, n = initArr.length, i = 0;
        while(i < n) {
            if(' ' == initArr[i]){
                i++;
                continue;
            }
            int curStart = i;
            //寻找单词最后一个字母的位置，并再次反转
            while (i < n && ' ' != initArr[i]){
                i++;
            }
            for (int j = curStart; j < i; j++) {
                if(j == curStart){
                    //反转单词
                    swap(initArr,curStart,i-1);
                }
                initArr[k++] = initArr[j];
                //增加一个空格
                if(j == i - 1){
                    if(k < n){
                        initArr[k++] = ' ';
                    }
                }
            }
        }
        if( k == 0){
            return "";
        }else{
            return new String(initArr,0,k == n && initArr[k-1] != ' ' ? k : k - 1);
        }
    }
    //颠倒区间[start, end]间的字母
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
        String s = " the sky is      blue ";
        System.out.println(reverseWords(s));

    }
}





