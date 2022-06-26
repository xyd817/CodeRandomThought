package binarytree;

import com.oracle.net.Sdp;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 111
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @author xyd
 * @create 2022-06-23 10:12
 */
public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if(leftDepth == 0 ){
            return rightDepth + 1;
        }else if(rightDepth == 0){
            return leftDepth + 1;
        }else{
            return Math.min(leftDepth,rightDepth) + 1;
        }
    }
    //迭代法
    public int minDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            depth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(node.left == null && node.right == null){
                     return depth;
                }
            }
        }
        return depth;

    }

    @Test
    public void test() {
        //String[] nums = {"3", "9", "20", "null", "null", "15", "7"};
        String[] nums = {"2", "null", "3", "null", "4", "null", "5", "null", "6"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(minDepth1(root));
    }
}
