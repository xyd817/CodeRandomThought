package backtracingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 17
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2 -> "abc" 3 -> "def"
 * 4 -> "ghi" 5 -> jkl 6 -> mno
 * 7 -> "pqrs" 8 -> "tuv" 9 -> "wxyz"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-12 7:52
 */
public class TelephoneNumberCombine {
    private Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    private List<String> ans = new ArrayList<>();
    private StringBuffer path = new StringBuffer();

    private void backtracing(String digits, int start) {
        if (path.length() == digits.length()) {
            ans.add(new String(path));
            return;
        }
        String letters = map.get(digits.charAt(start));
        for (int j = 0; j < letters.length(); j++) {
            path.append(letters.charAt(j));
            backtracing(digits, start + 1);
            path.delete(path.length() - 1, path.length());
        }
    }

    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return ans;
        }
        backtracing(digits, 0);
        return ans;
    }

    @Test
    public void test(){
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
