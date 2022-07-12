package backtracingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 40
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-12 11:26
 */
public class CombineII {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backtracing(int[] candidates, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            target -= candidates[i];
            path.add(candidates[i]);
            backtracing(candidates, target, i + 1);
            target += candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracing(candidates, target, 0);
        return ans;
    }

    @Test
    public void test() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}
