package binarytree;

import org.junit.Test;

/**
 * leetcode 701
 * 给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-08 10:06
 */
public class InsertOfBST {
    //迭代法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur != null) {
            parent = cur;
            if (val > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (parent.val > val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
        return root;
    }

    //使用递归的方法
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST1(root.left, val);
        } else {
            root.right = insertIntoBST1(root.right, val);
        }
        return root;
    }

    @Test
    public void test() {
        String[] nums = {"4", "2", "7", "1", "3"};
        int val = 5;
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        TreeNode node = insertIntoBST1(root, val);
        CreateTreeNode.inorder(node);
    }

}
