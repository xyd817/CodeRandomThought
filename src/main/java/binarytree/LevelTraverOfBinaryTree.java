package binarytree;

import org.junit.Test;

import javax.print.DocFlavor;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 102
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * @author xyd
 * @create 2022-06-20 8:37
 */
public class LevelTraverOfBinaryTree {
    //迭代法
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    //递归法
    public List<List<Integer>> levelOrder1(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        order(root, ans, 0);
        return ans;
    }
    public void order(TreeNode node, List<List<Integer>> ans ,int depth){
        if(node == null){
            return;
        }
        if(ans.size() == depth){
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(node.val);
        order(node.left,ans,depth + 1);
        order(node.right, ans, depth + 1);
    }

    @Test
    public void test() {
        String[] nums = {"3", "9", "20", "null", "null", "15", "7"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        List<List<Integer>> lists = levelOrder1(root);
        lists.forEach(x -> System.out.println(x));
    }
}
