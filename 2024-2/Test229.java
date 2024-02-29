import java.util.Comparator;
import java.util.PriorityQueue;

class Cmp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class Test229 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Cmp());
        priorityQueue.offer(4);
        priorityQueue.offer(2);
        System.out.println(priorityQueue.peek());
    }
}
