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
