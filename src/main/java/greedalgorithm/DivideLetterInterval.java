package greedalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 763
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 * @author xyd
 * @create 2022-09-08 7:14
 */
public class DivideLetterInterval {
    public List<Integer> partitionLabels(String s) {
        // 统计每一个字母出现的最后一个位置
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        int left = 0 , right = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if (right == i) {
                ans.add(right - left + 1);
                left = i + 1;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String str = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(str));
    }
}
