package binarytree;

import org.junit.Test;
import scala.reflect.internal.Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode:94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author xyd
 * @create 2022-06-17 10:29
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    //使用迭代法来完成中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;//左
            }else{
                cur = stack.pop();
                ans.add(cur.val);//处理中间节点
                cur = cur.right;//右
            }
        }
        return ans;

    }

    @Test
    public void test() {
        String[] roots = {"1", "null", "2", "3"};
        TreeNode root = CreateTreeNode.createBinaryTree(roots);
        List<Integer> list = inorderTraversal1(root);
        list.forEach(System.out::println);
    }

}
