package list;

import org.junit.Test;

/**
 *leetcode 24:
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @author xyd
 * @create 2022-05-23 9:03
 */
public class SwapAdjacentListNode {
    public ListNode swapPairs(ListNode head) {
        //链表为空或者只有一个节点的情况
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head , second = head.next;
        ListNode preFirst = null;
        while (first != null && second != null){
            ListNode afterSecond = second.next;
            if(first == head){
                first.next = afterSecond;
                second.next = first;
                head = second;
                preFirst = first;
            } else {
                preFirst.next = second;
                second.next = first;
                first.next = afterSecond;
                preFirst = first;
            }
            first = first.next;
            if(first != null){
                second = first.next;
            }
        }
        return head;
    }
    public void printList(ListNode head){
        if(head == null){
            return;
        }
        System.out.print(head.val + " ");
        printList(head.next);
    }
    public ListNode createList(int[] nums){
        if(nums == null){
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }
    @Test
    public void test(){
        int[] nums = {1,2,3,4};
        ListNode head = createList(nums);
        printList(swapPairs(head));
    }
}
