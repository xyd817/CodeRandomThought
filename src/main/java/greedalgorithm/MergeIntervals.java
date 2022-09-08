package greedalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 56
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-09-09 6:44
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans.get(ans.size() - 1)[1]) {
               ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    @Test
    public void test() {
        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] mergeIntervals = merge(intervals);
        for (int[] interval : mergeIntervals) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
    }

}
