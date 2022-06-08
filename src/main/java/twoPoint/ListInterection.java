package twoPoint;

import org.junit.Test;

/**
 * 面试题 02.07. 链表相交
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-06-08 9:58
 */
public class ListInterection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //求出两链表的长度
        int lenA = 0, lenB = 0;
        ListNode curA = headA;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        ListNode curB = headB;
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        //使链表对齐
        curA = headA;
        curB = headB;
        if (lenA > lenB) {
            int distance = lenA - lenB;
            while (distance > 0) {
                curA = curA.next;
                distance--;
            }
        } else {
            int distance = lenB - lenA;
            while (distance > 0) {
                curB = curB.next;
                distance--;
            }
        }
        //寻找交点节点
        while (curA != null && curB != null) {
            if (curA == curB) {
                break;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    @Test
    public void test() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        ListNode b1 = new ListNode(-1);
        ListNode b2 = new ListNode(-2);
        b1.next = b2;
        b2.next = a3;

        ListNode node = getIntersectionNode(a1, b1);
        System.out.println(node.val);

    }

}
