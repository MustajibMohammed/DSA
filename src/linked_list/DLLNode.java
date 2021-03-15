package linked_list;

public class DLLNode {
    private int data;
    private DLLNode prev;
    private DLLNode next;

    public DLLNode(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }

    public DLLNode(int data,DLLNode next,DLLNode prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }
}
