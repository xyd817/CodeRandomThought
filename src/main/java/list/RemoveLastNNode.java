package list;

import org.junit.Test;

/**
 *leetcode 19
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author xyd
 * @create 2022-05-24 8:16
 */
public class RemoveLastNNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        //使用快慢指针，快指针从亚头结点移动n + 1步，随后快慢指针一起移动，
        //快指针为null的时候，slow所在位置即为倒数第n个节点
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode slow = head, fast = head;
        while(n-- > 0){
            fast = fast.next;
        }
        ListNode preNode = null;
        while(fast != null){
            preNode = slow;
            fast = fast.next;
            slow = slow.next;
        }
        preNode.next = slow.next;
        return dummyNode.next;
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
        int n = 3;
        ListNode head = createList(nums);
        ListNode head1 = removeNthFromEnd(head, n);
        printList(head);
        System.out.println();
        printList(head1);
    }

}
