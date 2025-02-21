package com.strive.Tree;

public class LC1008 {
    static class LC1008_1 {
        //todo 解法1 效率最高 0ms 递归
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = new TreeNode(preorder[0]);
            for (int i = 1; i < preorder.length; i++) {
                int val = preorder[i];
                insert(root, val);
            }
            return root;
        }

        private TreeNode insert(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val < root.val) {
                root.left = insert(root.left, val);
            } else if (val > root.val) {
                root.right = insert(root.right, val);
            }
            return root;
        }
    }

    static class LC1008_2 {
        //todo 解法2 上限法 递归
        public TreeNode BstFromPreorder(int[] preorder) {
            return insert(preorder,Integer.MAX_VALUE);
        }
        /*
            依次处理preorder 中每个值，返回创建好的节点或null
            1.如果超过上限，返回null作为孩子返回
            2.如果没有超过上限，创建节点，并设置其左右孩子
              左右孩子完整后返回
        */
        int i = 0; //todo 数组中的索引位置
        private TreeNode insert(int[] preorder,int max) {
            if(i == preorder.length){
                return null;
            }
            int val = preorder[i];
            if(val > max){
                return null;
            }
            TreeNode node = new TreeNode(val);
            i++;
            node.left = insert(preorder,val);
            node.right = insert(preorder,max);
            return node;
        }
    }

    static class LC1008_3{
        //todo 解法3 分治法 递归
        public TreeNode bstFromPreorder(int[] preorder) {
            return partition(preorder,0,preorder.length - 1);
        }
        private TreeNode partition(int[] preorder,int start,int end){
            if(start > end){
                return null;
            }
            TreeNode root = new TreeNode(preorder[start]);
            int index = start + 1;
            while(index <= end){
                if(preorder[index] > preorder[start]){
                    break;
                }
                index++;
            }
            //todo index是右子树的起点
            root.left = partition(preorder,start + 1,index - 1);
            root.right = partition(preorder,index,end);
            return root;
        }
    }
}