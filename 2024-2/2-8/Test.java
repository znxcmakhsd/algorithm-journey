1. 反转单链表
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        if  (head == null) {
            return null;
        }
        ListNode cur = head.next;
        ListNode next = null;
        head.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }
    
}
*/

另外一种更好的写法:
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
*/

2. 反转双链表
/*
class LinkedList {
    static class ListNode {
        public ListNode last;
        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            head.last = next;
            prev = head;
            head = next;
        }
        return prev;
    }
}
*/

// 3. 二分搜索树 -未完
package Test;

public class BinarySearchTree {

    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    public boolean search(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            }else {
                return true;
            }
        }
        return false;
    }

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            parent = cur;
            if (val > root.val) {
                cur = cur.right;
            }else if (val < root.val) {
                cur = cur.left;
            }else {
                return;
            }
        }
        TreeNode node = new TreeNode(val);
        if (val > parent.val) {
            parent.right = node;
        }else {
            parent.left = node;
        }
    }
}
