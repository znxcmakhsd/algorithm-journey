package ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(0,4);
        arrayList.display();

        arrayList.remove(4);
        arrayList.display();

    }
}
