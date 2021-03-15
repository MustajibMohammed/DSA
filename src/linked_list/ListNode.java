package linked_list;

public class ListNode {
    private int  data;
    private ListNode next;

    public ListNode(int data){
        this.data=data;
    }

    public void setData(int Data){
        this.data=Data;
    }

    public int getData(){
        return this.data;
    }

    public void setNext(ListNode next){
        this.next=next;
    }

    public ListNode getNext(){
        return this.next;
    }
}


