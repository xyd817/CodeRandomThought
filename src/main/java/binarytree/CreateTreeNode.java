package binarytree;

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
            if(i + 2 < n && "null".equals(arrs[i + 2])){
                node.right = new TreeNode(Integer.parseInt(arrs[i + 2]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
