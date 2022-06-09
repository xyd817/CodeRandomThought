package twoPoint;

import org.junit.Test;

/**
 *leetcode 142
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链中表的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-06-09 8:19
 */
public class CircularListII {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        //使用快慢指针赛跑的方法来求链表交点
        ListNode slow = head,fast = head;
        while(true){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            //无环的情况
            if(fast == null){
                return null;
            }
            if(slow == fast){
                break;
            }
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    @Test
    public void test(){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a3;
        ListNode node = detectCycle(a1);
        System.out.println(node== null ? "null" : node.val);
    }
}
