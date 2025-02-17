public class DoublyList {

    public static class Node{
        int value;
        Node next,prev;

        Node(int value){
            this.value = value;
            this.next = this.prev = null;
        }
    }
    private Node head,tail;
//     insert at head
    public void insertAtHead(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev=newNode;
            head = newNode;
        }
    }
//    insert at tail
    public void insertAtTail(int val){
        Node newNode = new Node(val);
        if(tail == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
//    delete a node
    public  void deleteNode(int val){
        Node temp = head;
        while( temp != null && temp.value != val){
            temp = temp.next;
        }
        if(temp == null) return;
        if(temp == head){        //   delete head node
           head = head.next;
           head.prev = null;

        }else if(temp == tail){
            tail = tail.prev;
            tail.next = null;
        }else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }
//    display from head
    public void displayHead(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+"<->");
            temp = temp.next;
        }
        System.out.println("\n");
    }
//    display from tail
    public void displayTail(){
        Node temp = tail;
        while( temp !=null){
            System.out.print(temp.value+"<->");
            temp = temp.prev;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        DoublyList ddl = new DoublyList();
        ddl.insertAtHead(10);
        ddl.insertAtHead(20);
        ddl.insertAtHead(30);
        ddl.insertAtTail(40);
        ddl.insertAtTail(50);
        ddl.insertAtTail(60);
        ddl.displayHead();
        ddl.deleteNode(20);
        ddl.deleteNode(30);
        ddl.displayTail();
    }

}
