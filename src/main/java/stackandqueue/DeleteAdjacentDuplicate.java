package stackandqueue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 1047
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-06-12 9:51
 */
public class DeleteAdjacentDuplicate {
    public String removeDuplicates(String s) {
        if ("".equals(s) || s.length() < 1) {
            return s;
        }
        Deque<Character> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty() || queue.getLast() != s.charAt(i)) {
                queue.offerLast(s.charAt(i));
            } else {
                queue.pollLast();
            }
        }
        StringBuffer ans = new StringBuffer();
        while (!queue.isEmpty()){
            ans.append(queue.pollFirst());
        }
        return ans.toString();
    }
    @Test
    public void test(){
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
