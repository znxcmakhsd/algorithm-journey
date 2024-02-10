1. 合并两个有序链表
https://leetcode.cn/problems/merge-two-sorted-lists/
/*
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode c1 = head.next;
        ListNode c2 = head == list1 ? list2 : list1;
        ListNode pre = head;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                pre.next = c1;
                c1 = c1.next;
            }else {
                pre.next = c2;
                c2 = c2.next;
            }
            pre = pre.next;
        }
        pre.next = c1 == null ? c2 : c1;
        return head;
    }
}
*/

2. 两数相加
https://leetcode.cn/problems/add-two-numbers/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode cur = null;
        int carry = 0;
        for (int sum,v;
            l1 != null || l2 != null;
            l1 = l1 == null ? null : l1.next,
            l2 = l2 == null ? null : l2.next) {

            sum = (l1 == null ? 0 : l1.val) 
                    + (l2 == null ? 0 : l2.val) + carry;
            v = sum % 10;
            carry = sum / 10;

            if (ans == null) {
                ans = new ListNode(v);
                cur = ans;
            }else {
                cur.next = new ListNode(v);
                cur = cur.next;
            }
        }
        if (1 == carry) {
            cur.next = new ListNode(1);
        }
        return ans;
    }
}

3. 分隔链表
https://leetcode.cn/problems/partition-list/
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
    public ListNode partition(ListNode head, int x) {
        // < x
        ListNode leftHead = null,leftTail = null;
        // >= x
        ListNode rightHead = null,rightTail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                }else {
                    leftTail.next = head;
                }
                leftTail = head;
            }else {
                if (rightHead == null) {
                    rightHead = head;
                }else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }
}