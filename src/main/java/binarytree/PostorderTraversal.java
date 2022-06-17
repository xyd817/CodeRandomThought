package binarytree;

import org.junit.Test;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * leetcode:145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * @author xyd
 * @create 2022-06-17 10:22
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
    @Test
    public void test(){
        String[] roots = {"1","null","2","3"};
        TreeNode root = CreateTreeNode.createBinaryTree(roots);
        List<Integer> list = postorderTraversal(root);
        list.forEach(System.out::println);
    }
}
