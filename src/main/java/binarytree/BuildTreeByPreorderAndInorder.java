package binarytree;

import jdk.nashorn.internal.ir.ExpressionStatement;
import org.junit.Test;

import java.util.HashMap;

/**
 * leetcode 105
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，
 * 请构造二叉树并返回其根节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-02 11:17
 */
public class BuildTreeByPreorderAndInorder {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode traversal(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd <= preStart) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        if (preEnd - preStart == 1) {
            return root;
        }
        Integer mid = map.getOrDefault(val, preEnd - 1);
        root.left = traversal(preorder, preStart + 1, preStart + (mid - inStart) + 1, inorder, inStart, mid);
        root.right = traversal(preorder, preStart + (mid - inStart) + 1, preEnd, inorder, mid + 1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    @Test
    public void test() {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        CreateTreeNode.preOrder(root);
    }
}
