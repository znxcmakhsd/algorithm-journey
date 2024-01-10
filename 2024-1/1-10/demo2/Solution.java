package demo2;

public class Solution {

    // 数组实现队列
    public class AQueue {
        public int[] quque;
        public int l;
        public int r;

        public AQueue(int n) {
            quque = new int[n];
            l = 0;
            r = 0;
        }

        public boolean isEmpty() {
            return r == l;
        }

        public void offer(int num) {
            quque[r++] = num;
        }

        public int poll() {
            return quque[l++];
        }

        public int head() {
            return quque[l];
        }

        public int tail() {
            return quque[r-1];
        }

        // 有效数据个数
        public int size() {
            return r - l;
        }
    }


    // 数组实现栈
    public class Stack {
        public int[] stack;
        public int size;

        public Stack(int n) {
            this.stack = new int[n];
            this.size = 0;
        }

        public boolean isEmpty() {
            return 0 == size;
        }

        public void push(int num) {
            stack[size++] = num;
        }

        public int pop() {
            return stack[--size];
        }

        public int peek() {
            return stack[size-1];
        }

        public int size() {
            return size;
        }
    }

    // 数组实现循环队列
    // 自己写的 感觉不够好
    class MyCircularQueue {

        public int[] quque;
        public int limit;
        public int size;
        public int l;
        public int r;

        public MyCircularQueue(int k) {
            quque = new int[k];
            limit = k;
            l = 0;
            r = 0;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (size < limit) {
                quque[r] = value;
                r = r == limit-1 ? 0 : r+1;
                size++;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            l = l == limit-1 ? 0 : l+1;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return quque[l];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            int rear = r == 0 ? limit-1 : r-1;
            return quque[rear];
        }

        public boolean isEmpty() {
            return 0 == size;
        }

        public boolean isFull() {
            return size == limit;
        }
    }



}


// 浪费一个空间的方式判空
/*class MyCircularQueue {

    private int[] elem;
    private int front; // 指向队头
    private int rear;  // 指向队尾

    public MyCircularQueue(int k) {
        this.elem = new int[k+1];
        this.front = 0;
        this.rear = 0;
    }

    public boolean enQueue(int value) {
        // 满了不能入队
        if (isFull()) {
            return false;
        }
        this.elem[rear] = value;
        rear = (rear + 1) % elem.length;
        return true;
    }

    public boolean deQueue() {
        // 空了不能出队
        if (isEmpty()) {
            return false;
        }
        this.front = (front + 1) % elem.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (rear == 0) ? elem.length-1 : rear-1;
        return elem[index];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % elem.length == front;
    }
}*/

