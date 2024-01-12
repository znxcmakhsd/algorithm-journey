
1. 设计循环队列
https://leetcode.cn/problems/design-circular-queue/

class MyCircularQueue {
    public int[] queue;
    public int l,r,size,limit;

    public MyCircularQueue(int k) {
        queue = new int[k];
        l = r = size = 0;
        limit = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }else {
            queue[r] = value;
            r = r == limit - 1 ? 0 : r + 1;
            size++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }else {
            l = l == limit - 1 ? 0 : l + 1;
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
            int rear = r == 0 ? limit - 1 : r - 1;
            return queue[rear];
        }
    }
    
    public boolean isEmpty() {
        return 0 == size;
    }
    
    public boolean isFull() {
        return limit == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

// 2. 栈实现队列
https://leetcode.cn/problems/implement-queue-using-stacks/

// 每一个操作的时间复杂度是 O（1）
// 即使需要倒数据, 但是均摊到每个数据插入删除操作 执行次数为常数次 O(1)
class MyQueue {

    public Stack<Integer> in;
    public Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    public void inToOut() {
        if (out.isEmpty()) {
            while (!in.empty()) {
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

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

3. 用队列实现栈
https://leetcode.cn/problems/implement-stack-using-queues/

class MyStack {

    public Queue<Integer> queue ;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // O(N)
    public void push(int x) {
        int sz = queue.size();
        queue.offer(x);
        while (sz != 0) {
            queue.offer(queue.poll());
            sz--;
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

4. 最小栈
https://leetcode.cn/problems/min-stack/

使用java内置的stack
class MinStack {

    public Stack<Integer> data;
    public Stack<Integer> min;

    public MinStack() {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

方法2:
// 自己写的stack(数组) 实现 最小栈
class MinStack {

    public int[] data;
    public int[] min;
    public int size;
    public final int MAXN = 8001;

    public MinStack() {
        data = new int[MAXN];
        min = new int[MAXN];
        size = 0;
    }
    
    public void push(int val) {
        data[size] = val;
        if (size == 0 || val <= min[size-1]) {
            min[size] = val;
        }else {
            min[size] = min[size-1];
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


5. 实现双端队列

package deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 实现 双端队列
public class CircularDeque {

    // 1. 使用工具类 双向链表实现
    class MyCircularDeque1 {

        public Deque<Integer> deque;
        public int size;
        public int limit;

        public MyCircularDeque1(int k) {
            deque = new LinkedList<Integer>();
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
            }else {
                return deque.getFirst();
            }
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }else {
                return deque.getLast();
            }
        }

        public boolean isEmpty() {
            return 0 == size;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

    // 2. 自己用双向链表实现的双端队列
    class MyCircularDeque2 {

        static class ListNode {
            public ListNode prev;
            public int val;
            public ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }

        public ListNode head;
        public ListNode tail;
        public int size;
        public int limit;

        public MyCircularDeque2 (int k) {
            head = tail = null;
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            ListNode node = new ListNode(value);
            if (size == 0) {
                head = tail = node;
            }else {
                node.next = head;
                head.prev = node;
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
            if (size == 0) {
                head = tail = node;
            }else {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            size++;
            return true;

        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = head.next;
            if (head != null) {
                head.prev = null;
            }else {
                tail = null;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }else {
                head = null;
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
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

    // 3. 数组实现 双端队列
    class MyCircularDeque3 {

        public int[] deque;
        public int size,limit,r,l;

        public MyCircularDeque3(int k) {
            deque = new int[k];
            size = r = l = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                }else {
                    l = l == 0 ? (limit - 1) : (l - 1);
                    deque[l] = value;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                }else {
                    r = r == (limit - 1) ? 0 : (r + 1);
                    deque[r] = value;
                }
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }else {
                l = l == (limit - 1) ? 0 : l + 1;
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }else {
                r = r == 0 ? (limit - 1) : (r - 1);
                size--;
                return true;
            }
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }else {
                return deque[l];
            }
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }else {
                return deque[r];
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
