1. 单链表反转

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    public ListNode reverseList(ListNode head) {
        if  (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }
    */
    // public ListNode reverseList(ListNode head) {
    //     ListNode prev = null;
    //     ListNode next = null;
    //     while (head != null) {
    //         next = head.next;
    //         head.next = prev;
    //         prev = head;
    //         head = next;
    //     }
    //     return prev;
    // }
}

// 2. 反转双向链表
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