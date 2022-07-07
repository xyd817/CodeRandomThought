package binarytree;

import org.junit.Test;

/**
 * leetcode 236
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-07 11:43
 */
public class NearestAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    @Test
    public void test() {
        TreeNode a1 = new TreeNode(3);
        TreeNode b1 = new TreeNode(5);
        TreeNode b2 = new TreeNode(1);
        a1.left = b1;
        a1.right = b2;
        TreeNode c1 = new TreeNode(6);
        TreeNode c2 = new TreeNode(2);
        TreeNode c3 = new TreeNode(0);
        TreeNode c4 = new TreeNode(8);
        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        b2.right = c4;
        TreeNode d1 = new TreeNode(7);
        TreeNode d2 = new TreeNode(4);
        c2.left = d1;
        c2.right = d2;
        TreeNode p = c1, q = d2;
        TreeNode node = lowestCommonAncestor(a1, p, q);
        System.out.println(node.val);

    }
}
