package binarytree;

import org.junit.Test;
import scala.reflect.internal.Trees;

/**
 *leetcode 450
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-07-08 11:46
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        //1.二叉搜索树中没有键值为key节点
        if(root == null){
            return null;
        }
        if(root.val == key){
            //2.键值为key的节点为叶子结点
            if(root.left == null && root.right == null){
                return null;
            }
            //3.键值为key的节点左子树不为空，右子树为空
            if(root.left != null && root.right == null){
                return root.left;
            }
            //4.键值为key的节点右子树不为空，左子树为空
            if(root.left == null && root.right != null){
                return root.right;
            }
            //5.键值为key的节点左右子树均不为空
            TreeNode node = root.right;
            while (node.left != null){
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    //一般的二叉树删除节点
    public TreeNode deleteNode1(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.right == null){
                return root.left;
            }
            //寻找左子树的最小值
            TreeNode node = root.right;
            while (node.left != null){
                node = node.left;
            }
            root.val = node.val;
            node.val = key;
        }
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right, key);
        return root;
    }

    @Test
    public void test(){
        String[] nums = {"5", "3", "6", "2", "4", "null", "7" };
        int key = 3;
        TreeNode root = deleteNode1(CreateTreeNode.createBinaryTree(nums), key);
        CreateTreeNode.inorder(root);
    }
}
