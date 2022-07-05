package binarytree;

import org.junit.Test;

/**
 * leetcode 530
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author xyd
 * @create 2022-07-05 9:17
 */
public class MinimalABSOfBST {
    private int ans = Integer.MAX_VALUE;
    private TreeNode preNode = null;
    private void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);
        if(preNode != null){
            ans = Math.min(ans, root.val - preNode.val);
        }
        preNode = root;
        traversal(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
       traversal(root);
       return ans;
    }

    @Test
    public void test() {
        String[] nums = {"600", "424", "612", "null", "499", "null", "689"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(getMinimumDifference(root));
    }

}
