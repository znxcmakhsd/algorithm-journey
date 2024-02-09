package BST;

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

   /* public void insert(int val) {
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
    }*/

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            parent = cur;
            if (val > cur.val) {
                cur = cur.right;
            }else if (val < cur.val) {
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

    public void remove(int val) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (val > cur.val) {
                parent = cur;
                cur = cur.right;
            } else if (val < cur.val) {
                parent = cur;
                cur = cur.left;
            }else {
                // 找到了删除的节点 -> 删除
                removeNode(cur,parent);
                return;
            }
        }
    }

    private void removeNode(TreeNode cur,TreeNode parent) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        }else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }else if (cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            // 1. 找右边最小值替换删除
            TreeNode t = cur.right;
            TreeNode tp = cur;
            while (t.left != null) {
                tp = t;
                t = t.left;
            }
            cur.val = t.val;
            if (tp.right == t) {
                tp.right = t.right;
            }else {
                tp.left = t.right;
            }
        }
    }

}
