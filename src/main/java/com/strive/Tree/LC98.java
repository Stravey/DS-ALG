package com.strive.Tree;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

//todo 判断二叉搜索树是否合法
@SuppressWarnings("all")
public class LC98 {
    //todo 解法1
    //todo 中序遍历 非递归实现 1ms
    public boolean isValidBST(BSTNode root) {
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE;
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else if (!stack.isEmpty()){
                BSTNode pop = stack.pop();
                if(prev <= pop.key){
                    return false;
                }
                p = pop.right;
            }
        }
        return true;
    }

    //todo 解法2
    //todo 中序遍历 递归实现 0ms
    public boolean isBST(BSTNode root){
        long prev = Long.MIN_VALUE;
        BSTNode p =root;
        if(p == null)
            return true;
        boolean a = isBST(p.left);
        if(!a){
            return false;
        }
        if(prev >= p.key){
            return false;
        }
        prev = p.key;
        boolean b = isBST(p.right);
        return a && b;
    }

    //todo 解法3
    //todo 使用AtomicLong对象 递归方法 0ms
    public boolean isvalidBST(BSTNode root){
        return doValid(root, new AtomicLong(Long.MIN_VALUE));
    }
    public boolean doValid(BSTNode root,AtomicLong prev){
        if(root == null){
            return false;
        }
        boolean a = doValid(root.left,prev);
        if(!a){
            return false;
        }
        if(prev.get() >= root.key){
            return false;
        }
        prev.set(root.key);
        return doValid(root.right,prev);
    }

    //todo 解法4
    //todo 上下限递归实现 针对每个节点找出他们的上下限 0ms
    public boolean IsValidBST(BSTNode root){
        return dovalid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean dovalid(BSTNode root,long min,long max){
        if(root == null) {
            return true;
        }
        if(root.key <= min || root.key >= max){
            return false;
        }
        return dovalid(root.left,min,root.key) && dovalid(root.right,root.key,max);
    }
}
