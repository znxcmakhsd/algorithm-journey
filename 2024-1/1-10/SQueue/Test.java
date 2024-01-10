package SQueue;

public class Test {
    public static void main(String[] args) {
        SQueue sQueue = new SQueue();
        sQueue.offer(1);
        sQueue.offer(2);
        sQueue.offer(3);
        System.out.println(sQueue.poll());
        System.out.println(sQueue.poll());
        System.out.println(sQueue.poll());
    }
}
