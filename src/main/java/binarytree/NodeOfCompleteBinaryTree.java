package binarytree;

import org.junit.Test;

/**
 * leetcode 222
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-06-26 9:29
 */
public class NodeOfCompleteBinaryTree {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftNode = root.left, rightNode = root.right;//左右孩子节点
        int leftHeight = 0, rightHeight = 0;//左右子树的高度
        //求左右子树的高度
        while (leftNode != null) {
            leftNode = leftNode.left;
            leftHeight++;
        }
        while (rightNode != null) {
            rightNode = rightNode.right;
            rightHeight++;
        }
        if (rightHeight == leftHeight) {
            return (2 << leftHeight) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }

    @Test
    public void test() {
        String[] nums = {"1", "2", "3", "4", "5", "6"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(countNodes(root));
    }

}
