package binarytree;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 513
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 *
 * @author xyd
 * @create 2022-06-30 8:27
 */
public class FindLeftButtonValueOfTree {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = root.val;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    ans = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return ans;
    }

    //使用递归的写法
    public int findBottomLeftValue1(TreeNode root) {
        travel(root,0);
        return leftMaxValue;
    }
    private int leftMaxValue = Integer.MIN_VALUE;
    private int leftMaxLevel = -1;
    public void travel(TreeNode node, int curLen){
        //遇到叶子结点
        if(node.left == null && node.right == null){
            if(curLen > leftMaxLevel){
                leftMaxLevel = curLen;
                leftMaxValue = node.val;
            }
        }
        //左节点
        if(node.left != null){
            travel(node.left, curLen + 1);
        }
        //右节点
        if(node.right != null){
            travel(node.right, curLen + 1);
        }

    }


    @Test
    public void test() {
        String[] nums = {"1", "2", "3", "4", "null", "5", "6", "null", "null", "7"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(findBottomLeftValue1(root));
    }
}
