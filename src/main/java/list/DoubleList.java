package list;

/**
 * @author xyd
 * @create 2022-05-21 9:01
 */
public class DoubleList {
    int val;
    DoubleList next;
    DoubleList pre;
    public DoubleList(){}
    public DoubleList(int val){
        this.val = val;
    }
    public DoubleList(int val,DoubleList next,DoubleList pre){
        this.val = val;
        this.next = next;
        this.pre = pre;
    }

}
