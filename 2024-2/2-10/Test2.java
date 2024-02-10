package QueueAndStack;

public class Queue {

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 1. 链表实现的队列
    static class Queue1 {

        public ListNode head;
        public ListNode tail;

        public void offer(int val) {
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                tail = head;
            }else {
                tail.next = node;
                tail = tail.next;
            }
        }

        public int poll() {
            int tmp = head.val;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return tmp;
        }
    }
    // 2. 数组实现的队列
    static class queue2 {

        public int[] queue;
        public int l;
        public int r;

        public queue2(int n) {
            this.queue = new int[n];
            l = 0;
            r = 0;
        }

        public void offer(int val) {
            queue[r++] = val;
        }

        public int poll() {
            return queue[l++];
        }

        public boolean isEmpty() {
            return  l == r;
        }

        public int head() {
            return queue[l];
        }

        public int tail() {
            return queue[r-1];
        }

        public int size() {
            return r - l;
        }

    }

    // 3. 设计循环队列
    class MyCircularQueue {

        public int[] queue;
        public int l,r,size,limit;

        public MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }else {
                queue[r] = value;
                r = r == limit - 1 ? 0 : (r + 1);
                size++;
                return true;
            }
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }else {
                l = l == limit - 1 ? 0 : (l + 1);
                size--;
                return true;
            }
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }else {
                return queue[l];
            }
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }else {
                int last = r == 0 ? limit - 1 : (r - 1);
                return queue[last];
            }
        }

        public boolean isEmpty() {
            return 0 == size;
        }

        public boolean isFull() {
            return size == limit;
        }
    }




    public static void main(String[] args) {
        Queue1 queue1 = new Queue1();
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
    }
}
