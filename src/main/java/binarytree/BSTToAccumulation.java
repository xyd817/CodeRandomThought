package binarytree;

import org.junit.Test;

/**
 * leetcode
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-10 12:09
 */
public class BSTToAccumulation {
    private int curSum = 0;

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.right);
        root.val += curSum;
        curSum = root.val;
        traversal(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    @Test
    public void test() {
        String[] nums = {"4", "1", "6", "0", "2", "5", "7", "null", "null", "null", "3", "null", "null", "null", "8"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        CreateTreeNode.inorder(root);
        System.out.println();
        TreeNode ans = convertBST(root);
        CreateTreeNode.inorder(ans);
    }
}
