package binarytree;

import org.junit.Test;

import java.util.HashMap;

/**
 * leetcode 106
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-02 9:55
 */
public class BuildTreeByInorderAndPostorder {
    private HashMap<Integer, Integer> map = new HashMap<>();

    private TreeNode traversal(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        //判断是否为空数组
        if (inEnd <= inStart) {
            return null;
        }
        //构造根节点
        int val = postorder[postEnd - 1];
        TreeNode root = new TreeNode(val);

        //判断是否为叶子结点
        if ((inEnd - inStart) == 1) {
            return root;
        }
        //分割中序数组
        int midId = map.getOrDefault(val,inEnd - 1);
        root.left = traversal(inorder, inStart, midId, postorder, postStart, postStart + (midId - inStart));
        root.right = traversal(inorder, midId + 1, inEnd, postorder, postStart + (midId - inStart), postEnd - 1);
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i );
        }
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    @Test
    public void test() {
        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        CreateTreeNode.preOrder(root);
    }

}
