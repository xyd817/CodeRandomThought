package greedalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * leetcode 435
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-09-06 7:22
 */
public class NoOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            return x[1] - y[1];
        });
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    @Test
    public void test() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
