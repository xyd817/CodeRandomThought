package binarytree;

import org.junit.Test;

/**
 * leetcode 654
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-07-03 9:40
 */
public class MaximalBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createTree(nums, 0, nums.length - 1);
    }

    //寻找数组在[start,end]间的最大值所在的下标
    private int findMaxVal(int[] nums, int start, int end) {
        int ans = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[ans] < nums[i]) {
                ans = i;
            }
        }
        return ans;
    }

    private TreeNode createTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        //寻找最大值的下标
        int maxId = findMaxVal(nums, start, end);
        TreeNode root = new TreeNode(nums[maxId]);
        if (start == end) {
            return root;
        }
        root.left = createTree(nums, start, maxId - 1);
        root.right = createTree(nums, maxId + 1, end);
        return root;
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
        CreateTreeNode.preOrder(root);
    }


}
