package binarytree;

import org.junit.Test;

import javax.print.DocFlavor;
import javax.swing.*;
import java.util.*;

/**
 * leetcode 501
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-07-05 13:50
 */
public class ModeOfBST {
    private TreeNode preNode = null;
    private List<Integer> res = new ArrayList<>();
    private int maxCount = 0;
    private int count;
    private void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);
        if(preNode == null){
            count = 1;
        }else if(preNode.val == root.val){
            count++;
        }else {
            count = 1;
        }
        preNode = root;
        if(count == maxCount){
            res.add(root.val);
        }
        if(count > maxCount){
            res.clear();
            maxCount = count;
            res.add(root.val);
        }
        traversal(root.right);
    }

    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    //使用迭代法
    public int[] findMode1(TreeNode root) {
        int count = 0, maxCount = 0;
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode cur = root;
        TreeNode preNode = null;
        List<Integer> res = new LinkedList<>();
        while (cur != null || !st.isEmpty()){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }else{
                cur = st.pop();
                if(preNode == null){
                    count = 1;
                }else if(preNode.val == cur.val){
                    count++;
                }else{
                    count = 1;
                }
                if(count == maxCount){
                    res.add(cur.val);
                }
                if(count > maxCount){
                    res.clear();
                    maxCount = count;
                    res.add(cur.val);
                }
                preNode = cur;
                cur = cur.right;
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    @Test
    public void test(){
        String[] nums = {"1", "null", "2", "2" };
        TreeNode root = CreateTreeNode.createBinaryTree(nums);
        int[] modes = findMode1(root);
        for (int mode : modes) {
            System.out.println(mode);
        }
    }
}
