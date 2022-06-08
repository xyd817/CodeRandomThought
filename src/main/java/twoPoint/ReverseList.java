package twoPoint;

import org.junit.Test;

/**
 * @author xyd
 * @create 2022-06-08 9:18
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode temp = null;
        ListNode pre = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur= temp;
        }
        return pre;
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
        ListNode head = createList(nums);
        ListNode cur = reverseList(head);
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
