package binarytree;

import org.junit.Test;

import javax.print.DocFlavor;
import java.util.*;

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
    //使用迭代法完成后序遍历
    public List<Integer> postorderTraversal1(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
    @Test
    public void test(){
        String[] roots = {"1","null","2","3"};
        TreeNode root = CreateTreeNode.createBinaryTree(roots);
        List<Integer> list = postorderTraversal1(root);
        list.forEach(System.out::println);
    }
}
