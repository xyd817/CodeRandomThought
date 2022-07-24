package greedalgorithm;

import org.junit.Test;

/**
 * leetcode 122
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-24 4:19
 */
public class BestTimeOfShare {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int profit = 0;
        int prePrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > prePrice) {
                profit += (prices[i] - prePrice);
            }
            prePrice = prices[i];
        }
        return profit;
    }

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
