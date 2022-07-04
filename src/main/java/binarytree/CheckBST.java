package binarytree;

import org.junit.Test;

/**
 * leetcode 98
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-04 11:37
 */
public class CheckBST {
    private TreeNode preNode = null;
    public boolean isValidBST(TreeNode root) {
       if(root == null){
           return true;
       }
       boolean left = isValidBST(root.left);
       if(preNode != null && preNode.val >= root.val){
           return false;
       }
       preNode = root;
       boolean right = isValidBST(root.right);
       return left && right;
    }

    @Test
    public void test() {
        String[] nums = {"5", "1", "4", "null", "null", "3", "6"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        System.out.println(isValidBST(root));
        System.out.println(Integer.MAX_VALUE);
    }
}
