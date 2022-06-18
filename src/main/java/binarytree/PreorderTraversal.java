package binarytree;

import org.junit.Test;
import scala.reflect.internal.Trees;

import javax.print.DocFlavor;
import java.util.*;

/**
 * leetcode 144
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * @author xyd
 * @create 2022-06-17 9:28
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
    //使用迭代法完成前序遍历
    public List<Integer> preorderTraversal1(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return ans;
    }
    @Test
    public void test(){
        String[] roots = {"1","null","2","3"};
        TreeNode root = CreateTreeNode.createBinaryTree(roots);
        List<Integer> list = preorderTraversal1(root);
        list.forEach(System.out::println);

    }

}
