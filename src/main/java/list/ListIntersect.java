package list;

import org.junit.Test;

import java.awt.*;

/**
 * leetcode 面试题 02.07
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 *A    a1 - a2
 *                 \ c1 - c2 -c3
 *  b1 - b2 - b3   /
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xyd
 * @create 2022-05-24 8:54
 */
public class ListIntersect {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        //求出A链表的长度
        int lenA = 0;
        ListNode curA = headA;
        while(curA != null){
            lenA++;
            curA = curA.next;
        }
        //求出A链表的长度
        int lenB = 0;
        ListNode curB = headB;
        while(curB != null){
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        int grap = Math.max(lenA,lenB) - Math.min(lenA,lenB);
        //移动长度较长的链表开始节点的位置，使两链表尾端对齐
        if(lenA > lenB){
            while(grap-- > 0){
                curA = curA.next;
            }
        }else{
            while(grap-- > 0){
                curB = curB.next;
            }
        }
        while(curA != null && curB != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
    @Test
    public void test(){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ListNode b1 = new ListNode(7);
        b1.next = a3;
        ListNode node = getIntersectionNode(a1, b1);
        System.out.println(node.val);

    }
}
