package greedalgorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，
 * 也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，
 * 否则返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-09-03 9:25
 */
public class LemonadeWater {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bills[i] == 10) {
                Integer fiveNum = map.getOrDefault(5, 0);
                if (fiveNum != 0) {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.getOrDefault(10, 0) + 1);
                } else {
                    return false;
                }
            } else {
                Integer fiveNum = map.getOrDefault(5, 0);
                if (fiveNum == 0) {
                    return false;
                } else {
                    Integer tenNum = map.getOrDefault(10, 0);
                    if (tenNum > 0) {
                        map.put(10, tenNum - 1);
                        map.put(5, fiveNum - 1);
                    } else {
                        if (fiveNum >= 3) {
                            map.put(5, fiveNum - 3);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }
}
