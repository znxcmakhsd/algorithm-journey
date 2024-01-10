package MyLinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        /*myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);*/
       /* myLinkedList.addIndex(0,0);
        myLinkedList.addIndex(1,1);
        myLinkedList.addIndex(2,2);
        myLinkedList.addIndex(1,2);*/

        myLinkedList.addLast(2);
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(2);
        myLinkedList.removeAllKey(2);
        //myLinkedList.remove(3);
        myLinkedList.remove(1);
        myLinkedList.display();
    }
}
