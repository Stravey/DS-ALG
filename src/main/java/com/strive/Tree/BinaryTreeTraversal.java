package com.strive.Tree;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 */
@SuppressWarnings("all")
public class BinaryTreeTraversal {

    /**
     * 前序遍历 递归
     * @param root 根结点
     */
    public void preorderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    /**
     * 前序遍历 非递归
     * @param root 根结点
     */
    public void preOrderIterative(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val + " ");

            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历 递归
     * @param root
     */
    public void inorderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderRecursive(root.left);
        System.out.println(root.val + " ");
        inorderRecursive(root.right);
    }

    /**
     * 中序遍历 非递归
     * @param root 根结点
     */
    public void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.val + " ");
            curr = curr.right;
        }
    }

    /**
     * 后序遍历 递归
     * @param root 根结点
     */
    public void postorderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.println(root.val + " ");
    }

    /**
     * 后序遍历 非递归
     * @param root 根结点
     */
    public void postorderIterative(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> output = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node.val);
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }

        while(!output.isEmpty()) {
            System.out.println(output.pop() + " ");
        }
    }

    public void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val + " ");
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        BinaryTreeTraversal treeTraversal = new BinaryTreeTraversal();

        System.out.println("前序遍历 递归:");
        treeTraversal.preorderRecursive(root);
        System.out.println("前序遍历 非递归:");
        treeTraversal.preOrderIterative(root);

        System.out.println("中序遍历 递归:");
        treeTraversal.inorderRecursive(root);
        System.out.println("中序遍历 非递归:");
        treeTraversal.inorderIterative(root);

        System.out.println("后序遍历 递归:");
        treeTraversal.postorderRecursive(root);
        System.out.println("后序遍历 非递归:");
        treeTraversal.postorderIterative(root);

        System.out.println("层序遍历:");
        treeTraversal.levelOrder(root);
    }

}
