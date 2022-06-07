package list;

/**
 * leetcode 707
 *设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。
 * val是当前节点的值，next是指向下一个节点的指针/引用。如果要使用双向链表，
 * 则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，
 * 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xyd
 * @create 2022-05-21 9:03
 */
public class DesignList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        list.printList();
        System.out.println("==============================");
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));
    }

}
class MyLinkedList {
    private ListNode head ;
    private int len;
    public MyLinkedList() {
        head = new ListNode();
        len = 0;
    }
    //get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        //判断索引是否有效
        if(index < 0 || index > len - 1){
            return -1;
        }
        //遍历寻找第index各节点值
        ListNode cur = head;
        while(index >= 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    //addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    //addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        addAtIndex(len,val);
    }
    //addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，
    // 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if(index > len ){
            return;
        }
        //判断index是否小于等于0
        if(index < 0){
            index = 0;
        }
        ListNode preNode = head;
        //寻找第index个节点的前一个节点
        while(index > 0){
            preNode = preNode.next;
            index--;
        }
        ListNode node = new ListNode(val);
        node.next = preNode.next;
        preNode.next = node;
        len++;
    }
    // deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= len || len == 0){
            return;
        }
        ListNode preNode = head;
        while(index > 0){
            preNode = preNode.next;
            index--;
        }
        if(preNode.next != null){
            preNode.next = preNode.next.next;
        }
        len--;
    }

    public void printList(){
        ListNode cur = head.next;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
