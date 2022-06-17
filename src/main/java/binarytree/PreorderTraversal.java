package binarytree;

import org.junit.Test;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 144
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * @author xyd
 * @create 2022-06-17 9:28
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    @Test
    public void test(){

    }

}
