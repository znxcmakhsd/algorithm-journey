package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversalIteration {

    static class TreeNode {
        public TreeNode left;
        public int val;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 先序遍历 - 非递归实现 - 一个栈实现
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val+" ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        System.out.println();
    }
    // 测试:  https://leetcode.cn/problems/binary-tree-preorder-traversal/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ret.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return ret;
    }

    // 中序遍历 - 非递归实现 - 一个栈实现
    public static void inOrder(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                System.out.print(cur.val+" ");
                cur = cur.right;
            }
        }
        System.out.println();
    }
    // 测试链接 : https://leetcode.cn/problems/binary-tree-inorder-traversal/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                ret.add(cur.val);
                cur = cur.right;
            }
        }
        return ret;
    }

    // 后序遍历 - 非递归实现 - 两个栈实现
    public static void postOrderTwoStacks(TreeNode root) {
        if (root != null) {
            TreeNode cur = root;
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(cur);
            while (!stack.isEmpty()) {
                cur = stack.pop();
                collect.push(cur);
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
            while (!collect.isEmpty()) {
                System.out.print(collect.pop().val+" ");
            }
            System.out.println();
        }
    }


    // 后序遍历 - 非递归实现 - 一个栈实现
    public static void postOrderOneStacks(TreeNode root) {
       if (root != null) {

           Stack<TreeNode> stack = new Stack<>();
           TreeNode prev = root;
           stack.push(root);

           while (!stack.isEmpty()) {
               TreeNode cur = stack.peek();
               if (cur.left != null
                   && cur.left != prev
                   && cur.right != prev
               ) {
                   stack.push(cur.left);
               } else if (cur.right != null && cur.right != prev) {
                    stack.push(cur.right);
               } else {
                   System.out.print(cur.val + " ");
                   prev = stack.pop();
               }
           }
       }
        System.out.println();
    }
    // 测试: https://leetcode.cn/problems/binary-tree-postorder-traversal/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = root;
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null
                        && cur.left != prev
                        && cur.right != prev
                ) {
                    stack.push(cur.left);
                } else if (cur.right != null && cur.right != prev) {
                    stack.push(cur.right);
                } else {
                    ret.add(cur.val);
                    prev = stack.pop();
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        //preOrder(head);
        //inOrder(head);
        //postOrderTwoStacks(head);
        //postOrderOneStacks(head);

    }


}
