 public class MyLinkedList<Object> {
     private  Node head;
     private  int numNodes =0;

     public MyLinkedList() {
     }

     private class Node {
         private Node next;
         private Object data;

         public Node(Object data) {
             this.data = data;
         }

         public Object getData() {
             return this.data;
         }
     }
     public void add(int index, Object data) {
         Node temp = head;
         Node holder;

         for(int i=0; i < index-1 && temp.next != null; i++) {
             temp = temp.next;
         }
         holder = temp.next;
         temp.next = new Node(data);
         temp.next.next = holder;
         numNodes++;
     }
     public void addFirst(Object data) {
         Node temp = head;
         head = new Node(data);
         head.next = temp;
         numNodes++;
     }
     public void addLast(Object data) {  //thêm phần tử vào cuối danh sách
         Node temp = head;
         while (temp.next != null) {
             temp = temp.next;
         }
         temp.next = new Node(data);
         numNodes++;
     }
     public Object remote(int index) { //xóa phần tử thứ index
         if (index < 0 || index > numNodes) {
             throw new IndexOutOfBoundsException();
         }
         Node temp = head;
         Object data;
         if (index == 0) {
             data = temp.data;
             head = head.next;
         } else {
             for (int i = 0; i < index - 1 && temp.next != null; i++) {
                 temp = temp.next;
             }
             data = temp.next.data;
             temp.next = temp.next.next;
         }
         numNodes--;
         return (Object) data;
     }
     public boolean remoteElement(Object element) {
         if (head.data.equals(element)) {
             remote(0);
             return true;
         } else {
             Node temp = head;
             while (temp.next != null) {
                 if (temp.next.data.equals(element)) {
                     temp.next = temp.next.next;
                     numNodes--;
                     return true;
                 }
                 temp = temp.next;
             }
             return false;
         }
     }
     public Node get(int index){
         Node temp=head;
         for(int i=0; i<index; i++) {
             temp = temp.next;
         }
         return temp;
     }
     public void printList() {
         Node temp = head;
         while(temp != null) {
             System.out.println(temp.data);
             temp = temp.next;
         }
     }
     public MyLinkedList<Object> clone() {
         if (numNodes == 0) {
             throw new NullPointerException();
         }
         MyLinkedList<Object> temp = new MyLinkedList<>();
         Node tempNode = head;
         temp.addFirst((Object) tempNode.data);
         tempNode = tempNode.next;
         while (tempNode != null) {
             temp.addLast((Object) tempNode.data);
             tempNode = tempNode.next;
         }
         return temp;
     }
     public boolean contains(Object element) {  //kiểm tra phần tử có tồn tại trong danh sách hay không
         Node temp = head;
         while (temp.next != null) {
             if (temp.next.equals(element)) {
                 return true;
             }
             temp = temp.next;
         }
         if (temp.data.equals(element)) {
             return true;
         }
         return false;
     }
     public int indexOf(Object element) { //trả về vị trí của một phần tử trong ds
         Node temp = head;
         for (int i = 0; i < numNodes; i++) {
             if (temp.getData().equals(element)) {
                 return i;
             }
             temp = temp.next;
         }
         return -1;
     }
 }