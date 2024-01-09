package demo1;

class Solution {

    static class ListNode {
        // public Test.ListNode prev;
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode cur = null;
        int carry = 0;
        for (int sum, val;
             l1 != null || l2 != null;
             l1 = l1 == null ? null : l1.next,
             l2 = l2 == null ? null : l2.next
        ){
            sum = (l1 == null ? 0 : l1.val)
                    + (l2 == null ? 0 : l2.val) + carry;
            val = sum % 10;
            carry = sum / 10;

            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            }else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return ans;
    }
}