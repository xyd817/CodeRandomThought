package backtracingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 93
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是
 * 无效 IP 地址。给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入'.' 来形成。你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-07-15 9:53
 */
public class CopyIPAddress {
    private List<String> ans = new ArrayList<>();
    private StringBuffer path = new StringBuffer();
    private void backtracing(String s, int start,int numbers){
        if(start == s.length() && numbers == 4){
            ans.add(new String(path));
            return;
        }
        if(start == s.length() || numbers == 4){
            return;
        }
        for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
                && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
            if(i - start + 1 > 1 && s.charAt(start) == '0'){
                continue;
            }
            path.append(s.substring(start, i + 1));
            if(numbers < 3){
                path.append(".");
            }
            numbers++;
            backtracing(s, i + 1, numbers);
            numbers--;
            path.delete(start + numbers, path.length());
        }

    }

    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return ans;
        }
        backtracing(s,0,0);
        return ans;
    }

    @Test
    public void test(){
        String s = "25525511135";
        List<String> lists = restoreIpAddresses(s);
        System.out.println(lists);
    }
}
