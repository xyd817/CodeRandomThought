package Hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * leetcode 242
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 *
 * 说明: 你可以假设字符串只包含小写字母。
 * @author xyd
 * @create 2022-05-25 8:36
 */
public class ValidAnagramWord {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int cnt1 = map.getOrDefault(s.charAt(i),0) + 1;
            map.put(s.charAt(i),cnt1);
            int cnt2 = map.getOrDefault(t.charAt(i),0) - 1;
            map.put(t.charAt(i),cnt2);
        }
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Character, Integer> entry = it.next();
            Integer value = entry.getValue();
            if(value != 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
