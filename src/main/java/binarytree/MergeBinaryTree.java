package binarytree;

import org.junit.Test;

/**
 *leetcode 617
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-07-03 11:07
 */
public class MergeBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
       if(root1 == null){
           return root2;
       }
       if(root2 == null){
           return root1;
       }
       root1.val += root2.val;
       root1.left = mergeTrees(root1.left,root2.left);
       root1.right = mergeTrees(root1.right, root2.right);
       return root1;
    }


    @Test
    public void test(){
        String[] nums1 = {"1","3","2","5"}, nums2 = {"2","1","3","null","4","null","7"};
        TreeNode root1 = CreateTreeNode.createBinaryTree(nums1);
        TreeNode root2 = CreateTreeNode.createBinaryTree(nums2);
        TreeNode node = mergeTrees(root1, root2);
        CreateTreeNode.preOrder(node);
    }
}
