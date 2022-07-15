package backtracingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 131
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * @author xyd
 * @create 2022-07-14 7:44
 */
public class PartitionPolin {

    //判断字符串是否为回文串
    public boolean isPalindrome(String s, int start, int end){
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private List<List<String>> ans = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public void backtracing(String s, int start){
        if(start >= s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s,start,i)){
                String subStr = s.substring(start, i + 1);
                path.add(subStr);
            }else {
                continue;
            }
            backtracing(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        backtracing(s, 0);
        return ans;
    }

    @Test
    public void test(){
        String s = "aab";
        System.out.println(partition(s));
    }
}
