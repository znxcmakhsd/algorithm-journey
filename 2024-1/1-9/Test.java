复习:

1. 反转单链表
https://leetcode.cn/problems/reverse-linked-list/description/
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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
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
}

2. 合并两个有序链表
https://leetcode.cn/problems/merge-two-sorted-lists/description/
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
        // 处理特殊情况: 
        // 都为空 或者 一个为空 一个不为空
        if (listA == null || listB == null) {
            return listA == null ? listB : listA;
        }
        ListNode head = listA.val <= listB.val ? listA : listB;
        ListNode tail = head;
        ListNode curA = head.next;
        ListNode curB = head == listA ? listB : listA;
        while (curA != null && curB != null) {
            if (curA.val <= curB.val) {
                tail.next = curA;
                curA = curA.next;
            }else {
                tail.next = curB;
                curB = curB.next;
            }
            tail = tail.next;
        }
        tail.next = curA != null ? curA : curB;
        return head;
    }
}

3. 两数相加
https://leetcode.cn/problems/add-two-numbers/description/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = head;
        int carry = 0;
        for(int sum, val;
            l1 != null || l2 != null;
            l1 = l1 == null ? null : l1.next,
            l2 = l2 == null ? null : l2.next          
        ) {
            sum = (l1 == null ? 0 : l1.val) 
                + (l2 == null ? 0 : l2.val) + carry;

            val = sum % 10;
            carry = sum / 10;

            if (head == null) {
                head = new ListNode(val);
                tail = head;
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            } 
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return head;
    }
}

4. 分隔链表
https://leetcode.cn/problems/partition-list/description/
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
        ListNode leftHead = null, leftTail = null;
        // >= x;
        ListNode rightHead = null, rightTail = null;

        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                // < x
                if (leftHead == null) {
                    leftHead = cur;
    
                }else {
                    leftTail.next = cur;                   
                }
                leftTail = cur;

            }else {
                // >= x;
                if (rightHead == null) {
                    rightHead = cur;
                    
                }else {
                    rightTail.next = cur;
                }
                rightTail = cur;
            }
            cur = next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }
}