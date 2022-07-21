package backtracingalgorithm;

import com.sun.javafx.iio.common.PushbroomScaler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 51
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-21 4:50
 */
public class NQueue {
    private List<List<String>> ans = new ArrayList<>();

    private void backtracing(List<String> board, int row, int n) {
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, board, n)) {
                String rowStr = board.get(row);
                board.set(row, rowStr.substring(0, col) + "Q" + rowStr.substring(col + 1, n));
                backtracing(board, row + 1, n);
                board.set(row, rowStr);
            }
        }
    }

    //判断往棋盘（row,col)位置中加入皇后是否满足条件
    private boolean isValid(int row, int col, List<String> board, int n) {
        //判断列
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        //判断45度对角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        //判断135度对角
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String row = String.join("", Collections.nCopies(n,"."));
            board.add(row);
        }
        backtracing(board,0, n);
        return ans;
    }

    @Test
    public void test(){
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
