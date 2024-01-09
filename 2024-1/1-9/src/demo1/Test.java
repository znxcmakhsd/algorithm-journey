package demo1;


public class Test {
    static class ListNode {
        public ListNode prev;
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.prev = next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
