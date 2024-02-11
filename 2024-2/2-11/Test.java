package Test211;


import java.util.*;

public class Test {

    // 1. 循环队列
    class MyCircularQueue {

        public int l,r,size,limit;
        public int[] queue;

        public MyCircularQueue(int k) {
            r = l = size  = 0;
            queue = new int[k];
            limit = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }else {
                queue[r] = value;
                size++;
                r = r == limit - 1 ? 0 : (r + 1);
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
                int last = r == 0 ? limit - 1 : r - 1;
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

    // 2. 两个栈实现队列
    class MyQueue {

        public Stack<Integer> in;
        public Stack<Integer> out;

        public MyQueue() {
            in = new Stack();
            out = new Stack();
        }

        public void inToOut() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        public void push(int x) {
            in.push(x);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    // 3. 一个队列实现栈
    class MyStack {

        public Queue<Integer> stack;

        public MyStack() {
            stack = new LinkedList();
        }

        public void push(int x) {
            int n = stack.size();
            stack.offer(x);
            for (int i = 0;i < n;i++) {
                stack.offer(stack.poll());
            }
        }

        public int pop() {
            return stack.poll();
        }

        public int top() {
            return stack.peek();
        }

        public boolean empty() {
            return 0 == stack.size();
        }
    }
    // 4. 最小栈
    // 4.1 工具类实现
    class MinStack1 {
        public Stack<Integer> data;
        public Stack<Integer> min;

        public MinStack1() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            }else {
                min.push(min.peek());
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    // 4.2 自己写的栈实现
    class MinStack {

        public final int MAXN = 8001;

        public int[] data;
        public int[] min;
        public int size;

        public MinStack() {
            data = new int[MAXN];
            min = new int[MAXN];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            if (0 == size || val <= min[size - 1]) {
                min[size] = val;
            }else {
                min[size] = min[size - 1];
            }
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size-1];
        }

        public int getMin() {
            return min[size-1];
        }
    }

    // 5. 双端队列
    // 5.1 双向链表工具类实现
    class MyCircularDeque1 {

        public Deque<Integer> deque = new LinkedList<>();
        public int size;
        public int limit;

        public MyCircularDeque1(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }else {
                deque.addFirst(value);
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }else {
                deque.addLast(value);
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }else {
                deque.pollFirst();
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }else {
                deque.pollLast();
                size--;
                return true;
            }
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekFirst();
            }
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekLast();
            }
        }

        public boolean isEmpty() {
            return 0 == size;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

    // 自己写双向链表实现
    class MyCircularDeque {
        static class ListNode {
            public ListNode last;
            public ListNode next;
            public int val;

            public ListNode(int val) {
                this.val = val;
            }
        }

        public ListNode head;
        public ListNode tail;
        public int limit;
        public int size;

        public MyCircularDeque(int k) {
            head = tail = null;
            size = 0;
            limit = k;
        }

        // 头插
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            ListNode node = new ListNode(value);
            if (head == null) {
                head = tail = node;
            }else {
                head.last = node;
                node.next = head;
                head = node;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            ListNode node = new ListNode(value);
            if (head == null) {
                head = tail = node;
            }else {
                tail.next = node;
                node.last = tail;
                tail = tail.next;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = head.next;
            if (head == null) {
                tail = null;
            }else {
                head.last = null;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            ListNode pre = tail.last;
            if (pre == null) {
                head = tail = null;
            }else {
                pre.next = null;
                tail = pre;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }else {
                return head.val;
            }
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }else {
                return tail.val;
            }
        }

        public boolean isEmpty() {
            return 0 == size;
        }

        public boolean isFull() {
            return limit == size;
        }
    }
}
