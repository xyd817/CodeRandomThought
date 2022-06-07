package Hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 383
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-27 10:21
 */
public class RansomLetter {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int v = map.getOrDefault(c,0) + 1;
            map.put(c,v);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(map.containsKey(c)){
                int v = map.get(c) - 1;
                map.put(c,v);
                //ransomNote中的出现的字符c比magazine中的多
                if(v < 0){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
    public boolean canConstruct1(String ransomNote, String magazine){
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map[c - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int id  = ransomNote.charAt(i) - 'a';
            if(map[id] > 0){
                map[id]--;
            }else{
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
       String  ransomNote = "aa", magazine = "ab";
        System.out.println(canConstruct1(ransomNote,magazine));
    }
}
