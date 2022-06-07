package list;

import java.util.List;

/**
 * @author xyd
 * @create 2022-05-21 8:30
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(){

    }
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
