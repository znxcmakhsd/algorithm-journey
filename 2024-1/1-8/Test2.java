2. 合并两个有序链表
方法1:
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
    public ListNode mergeTwoLists(ListNode listA, ListNode listB) {
        if (listA == null && listB != null) {
            return listB;
        }
        if (listB == null && listA != null) {
            return listA;
        }
        ListNode head = null;
        ListNode tail = null;
        ListNode curA = listA;
        ListNode curB = listB;

        while (curA != null && curB != null) {
            if (curA.val < curB.val) {
                if (head == null) {
                    head = curA;
                    tail = head;
                }else {
                    tail.next = curA;
                    tail = tail.next;
                }
                curA = curA.next;
            }else {
                if (head == null) {
                    head = curB;
                    tail = head;
                }else {
                    tail.next = curB;
                    tail = tail.next;
                }
                curB = curB.next;
            }          
        }
        if (curA != null) {
            tail.next = curA;
        }
        if (curB != null) {
            tail.next = curB;
        }
        return head;
    }
}


更好的方法2:

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
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        // 处理一个为空 一个不为空
        if (headA == null || headB == null) {
            return headA == null ? headB : headA;
        }

        ListNode head = headA.val <= headB.val ? headA : headB;
        ListNode prev = head;
        ListNode curA = head.next;
        ListNode curB = head == headA ? headB : headA;
        
        while (curA != null && curB != null) {
            if (curA.val <= curB.val) {
                prev.next = curA;
                curA = curA.next;
            }else {
                prev.next = curB;
                curB = curB.next;
            }
            prev = prev.next;
        }
        prev.next = curA != null ? curA : curB;
        return head;
    }
}