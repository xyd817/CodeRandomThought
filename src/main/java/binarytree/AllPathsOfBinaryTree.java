package binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 257
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * @author xyd
 * @create 2022-06-27 8:39
 */
public class AllPathsOfBinaryTree {
    private List<String> path = new ArrayList<>();
    private List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        traversal(root);
        return ans;
    }

    public void traversal(TreeNode root) {
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            String s = new String();
            for (int i = 0; i < path.size() - 1; i++) {
                s += path.get(i);
                s += "->";
            }
            s += path.get(path.size() - 1);
            ans.add(s);
            return;
        }
        if(root.left != null){
            traversal(root.left);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            traversal(root.right);
            path.remove(path.size() - 1);
        }
    }
    @Test
    public void test(){
        String[] nums = {"1", "2" , "3" ,"null" , "5"};
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        List<String> list = binaryTreePaths(root);
        list.forEach(System.out::println);
    }

}
