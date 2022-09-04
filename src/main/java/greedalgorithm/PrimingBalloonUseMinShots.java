package greedalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * leetcode 452:
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组points，
 * 其中points[i] = [xstart, xend]表示水平直径在xstart和xend之间的气球。你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
 * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart≤ x ≤ xend，
 * 则该气球会被 引爆。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-09-05 7:07
 */
public class PrimingBalloonUseMinShots {
    public int findMinArrowShots(int[][] points) {
        if (points == null) {
            return 0;
        }
        Arrays.sort(points, (x,y) -> {
            return Integer.compare(x[0],y[0]);
        });
        int leftMinBound = points[0][1];
        int count = 1; // 气球不为空， 至少需要一个弓箭
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > leftMinBound) {
                count++;
                leftMinBound = points[i][1];
            } else {
                leftMinBound = Math.min(leftMinBound, points[i][1]);
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }
}
