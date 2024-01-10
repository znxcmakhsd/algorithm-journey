package MySingleList;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        /*mySingleList.addFirst(0);
        mySingleList.addFirst(1);
        mySingleList.addFirst(2);*/
        mySingleList.addLast(0);
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addIndex(4,4);
        mySingleList.display();

    }
}
