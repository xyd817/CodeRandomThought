package binarytree;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 112
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-01 7:39
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return travel(root, targetSum, 0);
    }

    public boolean travel(TreeNode root, int targetSum, int curSum) {
        if (root.left == null && root.right == null) {
            curSum += root.val;
            return targetSum == curSum ? true : false;
        }
        boolean leftAns = false, rightAns = false;
        if (root.left != null) {
            curSum += root.val;
            leftAns = travel(root.left, targetSum, curSum);
            curSum -= root.val;
        }
        if (root.right != null) {
            curSum += root.val;
            rightAns = travel(root.right, targetSum, curSum);
            curSum -= root.val;
        }
        return leftAns || rightAns;
    }

    //迭代法
    public boolean hasPathSum1(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        stack1.push(root);
        stack2.push(root.val);
        while (!stack1.isEmpty()){
            int len = stack1.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = stack1.pop();
                int val = stack2.pop();
                if(node.left == null && node.right == null && val == targetSum){
                    return true;
                }
                if(node.right != null){
                    stack1.push(node.right);
                    stack2.push(val + node.right.val);
                }
                if(node.left != null){
                    stack1.push(node.left);
                    stack2.push(val + node.left.val);
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        String[] nums = {"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "null", "1"};
        int targetSum = 22;
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(hasPathSum1(root, targetSum));
    }

}
