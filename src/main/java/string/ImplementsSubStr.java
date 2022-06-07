package string;

import org.junit.Test;

/**
 * leetcode 28
 * 实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回-1 。
 * 说明：
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。
 * 这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-06-03 9:49
 */
public class ImplementsSubStr {
    public int strStr(String haystack, String needle) {
        if("".equals(haystack)){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        int ans = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) != needle.charAt(0)){
                continue;
            }
            int dis = 0;
            while ( i + dis < haystack.length() && dis < needle.length() && haystack.charAt(i + dis) == needle.charAt(dis)){
                dis++;
            }
            if(dis == needle.length()){
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * KMP算法实现字符串匹配
     * 1.求出next数组，可以使用最长公共前缀表或者最长公共前缀减一作为next
     * 2.进行匹配
     *  j前缀末尾位置，i后缀末尾位置
     *  前、后缀相等：
     *      j、i同时更新
     *  前、后缀不相等：
     *      j = next[j] 回退
     *  如果j==模式串长度-1，返回结果
     */
    //依据模式串创建next数组
    public int[] getNext(String s){
        int n = s.length();
        int[] next = new int[n];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < n; i++) {
            //前后缀不相等，回退
            while(j >= 0 && s.charAt(j + 1) != s.charAt(i)){
                j = next[j];
            }
            //前后缀相等
            if(s.charAt(j + 1) == s.charAt(i)){
                j++;
            }
            //更新next数组
            next[i] = j;
        }
        return next;
    }

    public int strStr1(String haystack, String needle){
        if("".equals(haystack)){
            return -1;
        }
        int[] next = getNext(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if(j == needle.length() - 1){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }


    @Test
    public void test(){
        String haystack = "hello", needle = "ll";
        System.out.println(strStr1(haystack,needle));
        int x = 'd';
        System.out.println(x);
    }
}
