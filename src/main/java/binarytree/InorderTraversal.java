package binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode:94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author xyd
 * @create 2022-06-17 10:29
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    @Test
    public void test() {
        String[] roots = {"1", "null", "2", "3"};
        TreeNode root = CreateTreeNode.createBinaryTree(roots);
        List<Integer> list = inorderTraversal(root);
        list.forEach(System.out::println);
    }

}
