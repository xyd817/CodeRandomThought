package binarytree;

import com.sun.javafx.iio.common.PushbroomScaler;
import org.junit.Test;

/**
 * leetcode 235
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-07 12:16
 */
public class NearestAncestorOfBST {
    private TreeNode traversal(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return node;
        }
        if (node.val > p.val && node.val > q.val) {
            TreeNode left = traversal(node.left, p, q);
            if (left != null) {
                return left;
            }
        }
        if (node.val < p.val && node.val < q.val) {
            TreeNode right = traversal(node.right, p, q);
            if (right != null) {
                return right;
            }
        }
        return node;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }

    @Test
    public void test() {
        TreeNode a1 = new TreeNode(6);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(8);
        a1.left = b1;
        a1.right = b2;
        TreeNode c1 = new TreeNode(0);
        TreeNode c2 = new TreeNode(4);
        TreeNode c3 = new TreeNode(7);
        TreeNode c4 = new TreeNode(9);
        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        b2.right = c4;
        TreeNode d1 = new TreeNode(3);
        TreeNode d2 = new TreeNode(5);
        c2.left = d1;
        c2.right = d2;
        TreeNode p = b1, q = c3;
        TreeNode node = lowestCommonAncestor(a1, p, q);
        System.out.println(node.val);

    }

}
