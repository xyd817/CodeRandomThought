package binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 113
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-07-01 10:36
 */
public class PathSumII {
    private List<List<Integer>> ans = new LinkedList<>();
    private List<Integer> path = new LinkedList<>();
    public void traverval(TreeNode root, int count){
        if(root.left == null && root.right == null && count == 0){
            ans.add(new LinkedList<>(path));
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left != null){
            path.add(root.left.val);
            traverval(root.left, count - root.left.val);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            path.add(root.right.val);
            traverval(root.right, count - root.right.val);
            path.remove(path.size() - 1);
        }

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return ans;
        }
        path.add(root.val);
        traverval(root, targetSum - root.val);
        return ans;
    }
    @Test
    public void test() {
        String[] nums = {"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "null","5", "1"};
        //5,4,8,11,null,13,4,7,2,null,null,5,1
        int targetSum = 22;
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(pathSum(root, targetSum));
    }
}
