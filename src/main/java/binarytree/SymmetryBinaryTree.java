package binarytree;

import list.ListNode;
import org.junit.Test;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 101
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author xyd
 * @create 2022-06-22 8:15
 */
public class SymmetryBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else return compare(left.left, right.right) && compare(left.right, right.left);
    }
    //使用迭代法
    public boolean isSymmetric1(TreeNode root) {
        if(root == null){
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root.left);
        queue.push(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null){
                continue;
            }else if(left == null && right != null){
                return false;
            }else if(left != null && right == null){
                return false;
            }else if(left.val != right.val){
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
    @Test
    public void test() {
        String[] nums = {"1", "2", "2", "3", "4", "4", "3"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(isSymmetric1(root));
    }
}
