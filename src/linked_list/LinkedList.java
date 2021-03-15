package linked_list;


import java.util.List;

public class LinkedList {
    ListNode head;
    private int length=0;

    public LinkedList(){
        length=0;
    }

    public synchronized ListNode getHead(){
        return head;
    }

    public synchronized void insertAtBegin(ListNode node){
        node.setNext(head);
        head=node;
        length++;
    }

    public synchronized void insertAtEnd(ListNode node){
        ListNode p=head,q;
        if(head==null){
            head.setNext(node);
            length++;
            return;
        }
        else{
            while (p.getNext()!=null) {
                p = p.getNext();
            }
        }
        p.setNext(node);
        length++;
    }

    public synchronized void insertAtPosition(int data,int position){
        if(position<0){
            position=0;
        }

        if(position>length){
            position=length;
        }

        if(head==null){
            head=new ListNode(data);
        }

        else if(position==0){
            ListNode temp = new ListNode(data);
            temp.setNext(head);
            head=temp;
        }
        else{
            ListNode temp = head;
            for(int i=1;i<position;i++){
                temp=temp.getNext();
            }
            ListNode newNode= new ListNode(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        length+=1;
    }

    public synchronized ListNode removeFromBegin(){
        ListNode node=head;
        if(node!=null){
            head=node.getNext();
            node.setNext(null);
        }
        length--;
        return node;
    }

    public synchronized ListNode removeFromEnd(){
        if(head==null){
            return head;
        }
        ListNode p=head,q=null,next= head.getNext();
        if(next==null){
            head=null;
            length--;
            return p;
        }
        while((next=p.getNext())!=null){
            q=p;
            p=next;
        }
        q.setNext(null);
        length--;
        return p;
    }

    public synchronized void removeMatched(ListNode node){
        ListNode temp =head,temp1;
        if(head==null)
            return;
        if(node.equals(head)){
            head=head.getNext();
            length--;
            return;
        }
        while(temp.getNext()!=null){
            if(node.equals(temp.getNext())){
                temp1=temp.getNext();
                temp.setNext(temp1.getNext());
                length--;
                return;
            }
            temp=temp.getNext();
        }
        return;
    }

    public void remove(int position){
        if(position<0)
            position=0;
        if(position>=length)
            position=length-1;

        if(head==null){
            return;
        }

        if(position==0) {
            head = head.getNext();
        }

        else{
            ListNode temp = head;
            for(int i=0;i<position;i++){
                temp=temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        length--;
    }

    @Override
    public String toString() {
        String  result = "LinkedList{";
        if(head==null){
            return result + "length=" + length +"}";
        }
        result += head.getData();
        ListNode temp = head.getNext();
        while(temp!=null){
            result += ", " + temp.getData();
            temp = temp.getNext();
        }
        return result +
                "head=" + head +
                ", length=" + length +
                '}';
    }

    public int getLength() {
        return length;
    }

    public int getPosition(int Data){
        if(head==null){
            return 0;
        }
        ListNode temp =head;
        int pos=0;
        while(temp!=null){
            pos++;
            if(temp.getData()==Data){
                return pos;
            }
        }
        return -1;
    }

    public ListNode NthNodeFromEnd(ListNode head,int NthNode){
        ListNode temp = head,pNthNode=null;
        for(int i=1;i<NthNode;i++){
            if(temp!=null){
                temp=temp.getNext();
            }
        }
        pNthNode=head;
        while(temp!=null){
            temp=temp.getNext();
            pNthNode=pNthNode.getNext();
        }
        if(pNthNode!=null){
            return pNthNode;
        }
        return pNthNode;
    }

    public static Boolean findIfLoopExists(ListNode head){
        ListNode fstPtr = head;
        ListNode slwPtr = head;
        while(fstPtr!=null&&fstPtr.getNext()!=null){
            fstPtr=fstPtr.getNext().getNext();
            slwPtr=slwPtr.getNext();
            if(slwPtr==fstPtr){
                return true;
            }
        }
        return false;
    }

    public static ListNode findStartOfLoop(ListNode head){
        ListNode fstPtr = head;
        ListNode slwPtr = head;
        boolean ifLoopExists=false;
        while(fstPtr!=null&&fstPtr.getNext()!=null){
            fstPtr=fstPtr.getNext().getNext();
            slwPtr=slwPtr.getNext();
            if(slwPtr==fstPtr){
                ifLoopExists= true;
            }
        }
        if(ifLoopExists){
            fstPtr=head;
            while(fstPtr!=slwPtr){
                slwPtr=slwPtr.getNext();
                fstPtr=fstPtr.getNext();
            }
            return fstPtr;
        }
        return null;
    }

    public ListNode InsertInSortedList(ListNode head, ListNode newNode){
        ListNode current = head,temp=head;
        if(head==null)return newNode;
        while(current!=null && current.getData()<newNode.getData()){
            temp = current;
            current=current.getNext();
        }
        newNode.setNext(current);
        temp.setNext(newNode);
        return head;
    }

    public static ListNode reverseLinkedList(ListNode head){
        ListNode current = null;

        ListNode next = head;

        ListNode prev = null;

        while(next!=null){
            current=next;
            next=next.getNext();
            current.setNext(prev);
            prev=current;
        }
        head=current;
        return head;
    }

    public static ListNode findIntersectingNode(ListNode node1,ListNode node2){
        int l1=0,l2=0,diff=0;
        ListNode head1=node1,head2=node2;
        while(head1!=null){
            l1++;
            node1=node1.getNext();
        }
        while(head2!=null){
            l2++;
            node2=node2.getNext();
        }
        if(l1<l2){
            head1=node2;
            head2=node1;
            diff=l2-l1;
        }
        else {
            head1=node1;
            head2=node2;
            diff=l1-l2;
        }
        for(int i=0;i<diff;i++){
            head1=head1.getNext();
        }
        while(head1!=head2){
            if(head1==head2){
                return head1;
            }
            head1=head1.getNext();
            head2=head2.getNext();
        }
        return null;
    }

    public static ListNode findMiddle(ListNode head){
        ListNode slw=head,fst=head;
        int i=0;
        while(fst!=null&&fst.getNext()!=null&&fst.getNext().getNext()!=null){
            fst=fst.getNext().getNext();
            slw=slw.getNext();
        }
        return slw;
    }

    public int isLinkedListLengthEven(ListNode listHead){
        while(listHead != null && listHead.getNext()!=null){
            listHead=listHead.getNext().getNext();
        }
        if(listHead==null)return 0;
        return 1;
    }

    public ListNode mergeTwoLists(ListNode head1,ListNode head2){
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(head1!=null&&head2!=null){
            if(head1.getData()> head2.getData()){
                curr.setNext(head2);
                head2=head2.getNext();
            }
            else{
                curr.setNext(head1);
                head1=head1.getNext();
            }
        }
        if(head1!=null){
            curr.setNext(head1);
        }
        else{
            curr.setNext(head2);
        }
        return curr.getNext();
    }

    public static ListNode ReversePair(ListNode head){
        ListNode temp;
        if(head==null||head.getNext()==null){
            return head;
        }
        else{
            temp =head.getNext();
            head.setNext(temp.getNext());
            temp.setNext(head);
            head=temp;
            head.getNext().setNext(ReversePair(head.getNext().getNext()));
        }
        return head;
    }

    public static void SplitList(ListNode head,ListNode head1,ListNode head2){
        ListNode slwPtr = head,fstPtr = head;
        if(head==null)return;
        while(fstPtr.getNext()!=head&&fstPtr.getNext().getNext()!=head){
            fstPtr=fstPtr.getNext().getNext();
            slwPtr=slwPtr.getNext();
        }
        if(fstPtr.getNext().getNext()==null){
            fstPtr=fstPtr.getNext();
        }
        head1=head;
        if(head.getNext()!=head){
            head2=slwPtr.getNext();
        }
        fstPtr.setNext(slwPtr.getNext());
        slwPtr.setNext(head);
    }

    public ListNode exchangeAdjacent(ListNode head){
        ListNode temp = new ListNode(0);
        temp.setNext(head);
        ListNode prev=temp,curr=head;
        while(curr!=null&&curr.getNext()!=null){
            ListNode tmp = curr.getNext().getNext();
            curr.getNext().setNext(prev.getNext());
            prev.setNext(curr.getNext());
            curr.setNext(tmp);
            prev=curr;
            curr=prev.getNext();
        }
        return temp.getNext();
    }




}
