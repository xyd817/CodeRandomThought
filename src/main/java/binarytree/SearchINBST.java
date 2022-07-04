package binarytree;

import org.junit.Test;

/**
 * leetcode 700
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-04 9:34
 */
public class SearchINBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    //迭代法
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null){
            if(root.val == val){
                return root;
            }else if(root.val < val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return null;
    }
    @Test
    public void test() {
        String[] nums = {"4", "2", "7", "1", "3"};
        int val = 2;
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        TreeNode node = searchBST1(root, val);
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("null");
        }
    }
}
