package list;

import org.junit.Test;

/**
 *leetcode 203:
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @author xyd
 * @create 2022-05-21 8:29
 */
public class RemoveListElement {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next  = head;
        ListNode pre = dummyHead;
        while(head != null){
            if(head.val == val){
                head = head.next;
                pre.next = head;
            }else{
                pre = head;
                head = head.next;
            }
        }
        return dummyHead.next;
    }
    public ListNode createList(int[] nums, int id){
        if(nums.length == id){
            return null;
        }
        ListNode node = new ListNode(nums[id]);
        node.next = createList(nums,id + 1);
        return node;
    }
    public void printList(ListNode head){
        if(head == null){
            return;
        }
        System.out.print(head.val + " ");
        printList(head.next);
    }

    @Test
    public void test(){
        int[] nums = {1,2,6,3,4,5,6};
        int val = 6;
        ListNode head = createList(nums,0);
        ListNode head1 = removeElements(head, val);
        printList(head1);
    }
}
