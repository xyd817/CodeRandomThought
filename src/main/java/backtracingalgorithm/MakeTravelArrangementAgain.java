package backtracingalgorithm;

import org.junit.Test;

import java.util.*;

/**
 * leetcode 332
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-19 16:02
 */
public class MakeTravelArrangementAgain {
    private Map<String, Map<String, Integer>> map;
    private List<String> ans;

    private boolean backtracing(int ticketNum) {
        if (ans.size() == ticketNum + 1) {
            return true;
        }
        String last = ans.get(ans.size() - 1);
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> pair : map.get(last).entrySet()) {
                Integer value = pair.getValue();
                if (value > 0) {
                    ans.add(pair.getKey());
                    pair.setValue(value - 1);
                    if (backtracing(ticketNum)) {
                        return true;
                    }
                    ans.remove(ans.size() - 1);
                    pair.setValue(value);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        ans = new ArrayList<>();
        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) {
                Map<String, Integer> tmp = map.get(ticket.get(0));
                int cnt = tmp.getOrDefault(ticket.get(1), 0) + 1;
                tmp.put(ticket.get(1), cnt);
                map.put(ticket.get(0), tmp);
            } else {
                Map<String, Integer> tmp = new TreeMap<>();
                tmp.put(ticket.get(1), 1);
                map.put(ticket.get(0), tmp);
            }
        }
        ans.add("JFK");
        backtracing(tickets.size());
        return ans;
    }

    @Test
    public void test() {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<String>(){{
            add("MUC");
            add("LHR");
        }});
        tickets.add(new ArrayList<String>(){{
            add("JFK");
            add("MUC");
        }});
        tickets.add(new ArrayList<String>(){{
            add("SFO");
            add("SJC");
        }});
        tickets.add(new ArrayList<String>(){{
            add("LHR");
            add("SFO");
        }});

        System.out.println(findItinerary(tickets));
    }
}
