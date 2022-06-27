package binarytree;

import org.junit.Test;

/**
 * leetcode 404
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * @author xyd
 * @create 2022-06-27 10:16
 */
public class LeftLeafValueSum {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        getSum(root);
        return sum;
    }

    public void getSum(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        getSum(root.left);
        getSum(root.right);
    }

    @Test
    public void test() {
        String[] nums = {"1", "2", "3", "4", "5"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(sumOfLeftLeaves(root));
    }
}
