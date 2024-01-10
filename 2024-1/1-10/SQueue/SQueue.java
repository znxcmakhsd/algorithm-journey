package SQueue;

// 单链表实现队列
public class SQueue {

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;

    // 入队 - 尾插
    public void offer(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = tail = node;
        }else {
            tail.next = node;
            tail = tail.next;
        }
    }
    // 出队 - 头删
    public int poll() {
        int tmp = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return tmp;
    }

}
