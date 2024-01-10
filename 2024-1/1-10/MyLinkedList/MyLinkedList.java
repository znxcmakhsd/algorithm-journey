package MyLinkedList;

public class MyLinkedList implements IList{

    static class ListNode {
        private ListNode prev;
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;

    @Override
    public int size() {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = tail = node;
        }else {
            node.prev = tail;
            tail.next = node;
            tail = tail.next;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            throw new IndexException(index+"::非法index下标");
        }
        if (0 == index) {
            addFirst(data);
            return;
        }
        if (size() == index) {
            addLast(data);
            return;
        }
        // 中间插入
        ListNode node = new ListNode(data);
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        node.prev = cur.prev;
        node.next = cur;
        cur.prev.next = node;
        cur.prev = node;
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                // 头删
                if (cur == head) {
                    head = head.next;
                    if (head == null) {
                        tail = null;
                        break;
                    }
                    head.prev = null;
                }else {
                    // 自己写的 不好... 虽然能实现功能
                   /* ListNode prev = cur.prev;
                    prev.next = cur.next;
                    if (cur == tail) {
                        tail = prev;
                        break;
                    }
                    cur.next.prev = prev;*/

                    if (cur == tail) {
                        tail = cur.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
                break;
            }
            cur = cur.next;
        }
    }

    @Override
    public void removeAllKey(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                // 头删
                if (cur == head) {
                    head = head.next;
                    if (head == null) {
                        tail = null;
                        break;
                    }
                    head.prev = null;
                }else {
                    // 自己写的 不好... 虽然能实现功能
                   /* ListNode prev = cur.prev;
                    prev.next = cur.next;
                    if (cur == tail) {
                        tail = prev;
                        break;
                    }
                    cur.next.prev = prev;*/
                    if (cur == tail) {
                        tail = cur.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
            }
            cur = cur.next;
        }
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
    }
}
