package binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xyd
 * @create 2022-06-17 9:36
 */
public class CreateTreeNode {
    //通过输入数组来创建二叉树
    public static TreeNode createBinaryTree(String[] arrs){
        if(arrs == null || "null".equals(arrs[0])){
            return null;
        }
        int n = arrs.length;
        TreeNode root = null;
        TreeNode node;
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(i == 0){
                node = new TreeNode(Integer.parseInt(arrs[i]));
                root = node;
                queue.offer(root);
            }
            if(!queue.isEmpty()){
                node = queue.poll();
            }else{
                break;
            }
            if(i + 1 < n && !"null".equals(arrs[i + 1])){
                node.left = new TreeNode(Integer.parseInt(arrs[i + 1]));
                queue.offer(node.left);
            }
            if(i + 2 < n && !"null".equals(arrs[i + 2])){
                node.right = new TreeNode(Integer.parseInt(arrs[i + 2]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    //前序遍历
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }
    //中序遍历
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
