package com.strive.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
//todo:二叉搜索树  O(lgn) 和 java中的 map 相似
public class BST1 {

    BSTNode root;

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //todo：查找关键字对应的值
    //todo:   key  ————  关键字的值
    //todo:   关键字对应的值
    public Object get(int key) {
        return doGet(root,key);
    }
    public Object get1(int key) {
        BSTNode node = root;
        while(node != null){
            if(key < node.key){
                node = node.left;
            }else if(key > node.key){
                node = node.right;
            }else{
                return node.value;
            }
        }
        return null;
    }
    private Object doGet(BSTNode node,int key){
        if(node == null){
            return null;
        }
        if(key < node.key){
            doGet(node.left,key);//向左找
        } else if (key > node.key) {
            doGet(node.right,key);//向右找
        }else {
            return node.value;
        }
        return node.value;
    }

    //todo:寻找最小元素的值 最小关键字的值
    public Object min() {
        return doMin(root);
    }
    public Object min(BSTNode node) {
        if(root == null){
            return null;
        }
        BSTNode p = root;
        if(p.left != null){
            p = p.left;
        }
        return p.value;
    }
    private Object doMin(BSTNode node) {
        if(node == null){
            return null;
        }
        if(node.left == null) {
            return node.value;
        }
        return doMin(node.left);
    }

    //todo:查找最大关键字对应值
    public Object max() {
        return max(root);
    }
    private Object max(BSTNode node){
        if(node == null){
            return null;
        }
        BSTNode p = root;
        while(p.right != null){
            p = p.right;
        }
        return p.right;
    }
    private Object doMax(BSTNode node){
        if(node == null){
            return null;
        }
        if(node.right == null){
            return node.value;
        }
        return doMax(node.right);
    }

    //todo:存储关键字的对应值
    public void put(int key, Object value) {
        BSTNode node = root;
        BSTNode parent = null;
        while(node != null){
            parent = node;
            if(key < node.key){
                node = node.left;
            }else if(key > node.key){
                node = node.right;
            }else{
                //1.key 有 更新
                node.value = value;
                return;
            }
        }
        //2.key 没有 新增
        new BSTNode(key,value);
        assert parent != null;
        if(key < parent.key){
            parent.left = new BSTNode(key, value);
        } else {
            parent.right = new BSTNode(key,value);
        }
    }

    //todo:查找关键字的前驱值
    //todo:利用二叉树的中序遍历  左 根 右  (性能不高)
    //todo:方法：1.节点有左子树，此时前驱节点就是左子树的最大值
    //todo:方法：2.节点没有左子树，若离它最近的祖先自从左而来，此祖先即为前驱
    public Object precursor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromLeft = null;
        while(p != null){
            if(key < p.key){
                p = p.left;
            } else if (key > p.key) {
                ancestorFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }
        //没找到节点
        if(p == null) {
            return null;
        }
        //找到节点
        //todo:方法：1.节点有左子树，此时前驱节点就是左子树的最大值
        if(p.left != null) {
            return max(p.left);
        }
        //todo:方法：2.节点没有左子树，若离它最近的祖先自从左而来，此祖先即为前驱
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }

    //todo:查找关键字的后继值
    //todo:方法：1.节点有右子树，此时后继节点就是右子树的最小值
    //todo:方法：2.节点没有右子树，若离它最近的祖先自从右而来，此祖先即为后继
    public Object successor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while(p != null) {
            if(key < p.key) {
                ancestorFromRight = p;
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                break;
            }
        }
        //todo 没找到节点
        if(p == null) {
            return null;
        }
        //todo 找到节点
        //todo:方法：1.节点有右子树，此时后继节点就是右子树的最小值
        if(p.left != null) {
            return min(p.right);
        }
        //todo:方法：2.节点没有右子树，若离它最近的祖先自从右而来，此祖先即为后继
        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }

    //todo:根据关键字删除  非递归方法
    //todo:情况1:删除节点没有左孩子，将右孩子托付给parent
    //todo:情况2:删除节点没有右孩子，将左孩子托付给parent
    //todo:情况3:删除节点左右孩子都没有，已经被涵盖在情况1、情况2中，把null托付给parent
    //todo:情况4:删除节点左右孩子都有，可以将它的后继节点（S）托付给parent，再称S的父亲为SP 又分为两种情况：
    // （1）SP就是被删除节点，此时D与S紧邻，只需将S托付给parent
    // （2）SP不是被删除节点，此时D与S不相邻，此时需要将S的后代托付给SP，再将S托付给parent
    public Object delete(int key){
        BSTNode p = root;
        BSTNode parent = null;
        while(p != null){
            if(key < p.key){
                parent = p;
                p = p.left;
            } else if (key > p.key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if(p == null){
            return null;
        }
        //todo:删除操作
        if(p.left == null && p.right != null){
            //todo:情况1：删除节点没有左孩子，将右孩子托付给parent
            shift(parent,p,p.right);
        } else if (p.right == null && p.left != null) {
            //todo:情况2：删除节点没有右孩子，将左孩子托付给parent
            shift(parent,p,p.left);
        } else {
            //todo  情况4
            // 4.1 被删除节点找后继
            BSTNode s = p.right;
            BSTNode sParent = p;
            while(s.left != null){
                sParent = s;
                s = s.left;
            } // 后继节点即为s
            if(sParent != p){
                // 4.2 处理后继的后事
                shift(sParent,s,s.right);  //不可能有左孩子
                s.right = p.right;
            }
            // 4.3 后继处理被删除节点
            shift(parent,p,s);
            s.left = p.left;
        }
        return p.value;
    }
    //todo:托付方法
    //todo:parent 被删除节点的父亲
    //todo:deleted 被删除节点
    //todo:child 被顶上去的节点
    private void shift(BSTNode parent,BSTNode deleted,BSTNode child){
        if(parent == null){
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    //todo:根据关键字删除  递归方法
    public Object deleted(int key){
        ArrayList<Object> result = new ArrayList<>(); //todo:记录被删除节点的值
        root = doDelete(root,key,result);
        return result;
    }
    private BSTNode doDelete(BSTNode node,int key,ArrayList<Object> result){
        if(node == null){
            return null;
        }
        if(key < node.key){
            node.left = doDelete(node.left,key,result);
            return node;
        } else if (key > node.key) {
            node.right = doDelete(node.right,key,result);
            return node;
        }
        result.add(node.value);
        //todo:情况1 - 只有右孩子
        if(node.left != null){
            return node.right;
        }
        //todo:情况2 - 只有左孩子
        if(node.right != null){
            return node.left;
        }
        //todo:情况3 - 左右孩子
        BSTNode s = node.right;
        while(s.left != null){
            s = s.left;
        }
        s.right = doDelete(node.right,s.key,new ArrayList<>());
        s.left = node.left;
        return s;
    }


    //todo 二叉搜索树 范围查询 使用二叉树的中序遍历非递归形式 需要用到栈
    //todo 找 < key 的所有 value
    public List<Object> less(int key){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        //todo 向前进p！=null  向回走！stack.isEmpty()
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                BSTNode pop = stack.pop();
                //todo 处理值
                if(pop.key < key){
                    result.add(pop.value);
                }else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }
    //todo 找 > key 的所有 value
    //todo 使用中序遍历必须要遍历完整个树才可以找到 效率过低
    //todo 优化 反向中序遍历 reverse in-order
    public List<Object> greater(int key){
        /*ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        //todo 向前进p！=null  向回走！stack.isEmpty()
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                BSTNode pop = stack.pop();
                //todo 处理值
                if(pop.key > key){
                    result.add(pop.value);
                }
                p = pop.right;
            }
        }
        return result;*/

        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        //todo 向前进p！=null  向回走！stack.isEmpty()
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.right;
            }else {
                BSTNode pop = stack.pop();
                //todo 处理值
                if(pop.key > key){
                    result.add(pop.value);
                }else {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }
    //todo 找 >= key1 且 <= key2 的所有 value
    public List<Object> between(int key1,int key2){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        //todo 向前进p！=null  向回走！stack.isEmpty()
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                BSTNode pop = stack.pop();
                //todo 处理值
                if(pop.key >= key1 && pop.key <= key2){
                    result.add(pop.value);
                }else if(pop.key > key2){
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    //todo 二叉搜索树中插入值
    //todo 递归版本
    public BSTNode insertBST(BSTNode node,int val){
        if(node == null)
            return new BSTNode(val);
        if(val < node.key){
            node.left = insertBST(node.left,val);
        } else if (val > node.key) {
            node.right = insertBST(node.right,val);
        }
        return node;
    }
}