package binarytree;

import org.junit.Test;

/**
 * @author xyd
 * @create 2022-06-26 10:13
 */
public class BalanceBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        boolean res = Math.abs(left - right) <= 1 ? true : false;
        return res && isBalanced(root.left) && isBalanced(root.right);
    }

    //求子树高度
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    @Test
    public void test() {
        String[] nums = {"1", "2", "2", "3", "3", "null", "null", "4", "4"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(isBalanced(root));
    }


}
