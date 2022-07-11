package backtracingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 216
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-11 11:38
 */
public class CombineSumIII {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backtracing(int n, int k, int start) {
        if(n < 0){
            return;
        }
        if (path.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            n -= i;
            backtracing(n, k, i + 1);
            path.remove(path.size() - 1);
            n += i;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracing(n, k, 1);
        return ans;
    }

    @Test
    public void test() {
        int k = 3, n = 9;
        List<List<Integer>> lists = combinationSum3(k, n);
        System.out.println(lists);
    }
}
