package backtracingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 77
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * @author xyd
 * @create 2022-07-11 11:20
 */
public class Combine {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    //回溯算法求解
    private void backtracing(int n, int k, int start){
        //边界条件
        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }
        //单层处理逻辑加剪枝操作
        for (int i = start; i <= n -(k - path.size()) + 1; i++) {
            path.add(i);
            backtracing(n,k,i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtracing(n,k, 1);
        return ans;
    }

    @Test
    public void test(){
        int n = 4, k = 2;
        List<List<Integer>> lists = combine(n, k);
        System.out.println(lists);
    }
}
