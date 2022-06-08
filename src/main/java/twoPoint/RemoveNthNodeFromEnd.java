package twoPoint;

import org.junit.Test;

/**
 * leetcode 19
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author xyd
 * @create 2022-06-08 9:36
 */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0 ){
            return head;
        }
        //使用快慢指针的方法
        //快指针先走n步，然后快慢一起走，快指针到达链表末尾，慢指针即为倒数第n个节点
        //由于要找到倒数第n个节点的前驱，故增加一个哑结点，慢指针从哑结点出发
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = head;
        while(n > 0 && fast != null){
            fast = fast.next;
            n--;
        }
        //n大于链表的长度
        if(fast == null && n > 0 ){
            return head;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
    public ListNode createList(int[] nums){
        ListNode after = null;
        int n = nums.length;
        for (int i = n - 1; i >= 0  ; i--) {
            ListNode node = new ListNode(nums[i],after);
            after = node;
        }
        return after;
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5};
        int n = 2;
        ListNode head = createList(nums);
        ListNode cur = removeNthFromEnd(head, n);
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

    }
}
