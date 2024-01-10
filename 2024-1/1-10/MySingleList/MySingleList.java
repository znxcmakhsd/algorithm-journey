package MySingleList;

public class MySingleList implements  IList{

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;

    // 头插
    @Override
    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    // 尾插
    @Override
    public void addLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        }else {
            // 找尾
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    // index位置插入
    @Override
    public void addIndex(int index, int data) {
        // 检查index位置是否合法
        if (index < 0 || index > size()) {
            throw new IndexException(index + " :输入的Index位置不合法");
        }
        // 头插
        if (index == 0) {
            addFirst(data);
            return;
        }
        // 尾插
        if (index == size()) {
            addLast(data);
            return;
        }
        // 中间插入
        ListNode newNode = new ListNode(data);
        ListNode prev = head;
        // 找到插入节点的前一个 = index-1步
        while (index-1 != 0) {
            prev = prev.next;
            index--;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }

    // 查找是否包含关键字key是否在单链表当中
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
        ListNode prev = null;

        while (cur != null) {
            if (cur.val == key) {
                // 头删
                if (cur == head) {
                    head = head.next;
                }else {
                    prev.next = cur.next;
                }
                cur = cur.next;
                break;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    public void removeAllKey(int key) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            if (cur.val == key) {
                // 头删
                if (cur == head) {
                    head = head.next;
                }else {
                    prev.next = cur.next;
                }
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    public int size() {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void clear() {
        this.head = null;
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
}
