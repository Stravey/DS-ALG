package com.strive.Tree;

import java.util.LinkedList;

public class LC938 {
    //todo 解法1 中序遍历非递归实现 4ms
    public int rangeSumBST(BSTNode root, int low, int high) {
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        int sum = 0;
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                BSTNode pop = stack.pop();
                if(pop.key > high){
                    break;
                }
                if(pop.key >= low){
                    sum += pop.key;
                }
                p = pop.right;
            }
        }
        return sum;
    }

    //todo 解法2 上下限递归 0ms
    public int RangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        if(root.val < low){
            return RangeSumBST(root.right,low,high);
        }
        if(root.val > high){
            return RangeSumBST(root.left,low,high);
        }
        return root.val + RangeSumBST(root.left,low,high) + RangeSumBST(root.right,low,high);
    }

}
