package binarytree;

import org.junit.Test;

/**
 * leetcode 226
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author xyd
 * @create 2022-06-20 9:22
 */
public class OverturnBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        overturn(root);
        return root;
    }

    public void overturn(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        overturn(root.left);
        overturn(root.right);
    }

    @Test
    public void test() {
        String[] nums = {"4", "2", "7", "1", "3", "6", "9"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        TreeNode node = invertTree(root);
        CreateTreeNode.preOrder(node);
    }
}
