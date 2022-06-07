package list;

import org.junit.Test;

import java.util.List;

/**
 * leetcode 206
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @author xyd
 * @create 2022-05-23 8:23
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode();
        //就地逆置
        ListNode curNode = head;
        while(curNode != null){
            ListNode next = curNode.next;
            curNode.next = dummyHead.next;
            dummyHead.next = curNode;
            curNode = next;
        }
        return dummyHead.next;
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
        int[] nums = {1,2,3,4,5};
        ListNode head = createList(nums);
        printList(reverseList(head));
    }
}
