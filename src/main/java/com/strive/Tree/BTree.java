package com.strive.Tree;

import java.util.Arrays;

public class BTree {
    static class Node{
        int[] keys; //todo 关键字
        Node[] children; //todo 孩子
        int keyNumber; //todo 有效关键字数目
        boolean leaf = true; //todo 是否是叶子节点
        int t; //todo 最小度数(最小孩子数)

        public Node(int t) {
            this.t = t;
            this.children = new Node[2 * t];
            this.keys = new int[2 * t - 1];
        }

        @Override
        public String toString(){
            return Arrays.toString(Arrays.copyOfRange(keys,0,keyNumber));
        }

        //todo 多路查找
        Node get(int key){
          int i = 0;
          while(i < keyNumber) {
              if (keys[i] == key) {
                  return this;
              }
              if (keys[i] > key) {
                  break;
              }
              i++;
          }
          //todo 执行到此时 keys[i] > key 或 i == keyNumber
          if(leaf){
              return null;
          }
          //todo 非叶子情况
          return children[i].get(key);
        }
        //todo 向指定索引处插入key
        void insertKey(int key,int index){
            System.arraycopy(keys,index,keys,index + 1,keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }
        //todo 向指定索引处插入child
        void insertChild(Node child,int index){
            System.arraycopy(children,index,children,index + 1,keyNumber - index);
            children[index] = child;
        }

        //todo 删除的静态内部类方法
        //todo 移除指定 index 处的 key
        int removeKey(int index){
            int t = keys[index];
            System.arraycopy(keys,index + 1,keys,index,--keyNumber - index);
            return t;
        }
        //todo 移除最左边的key
        int removeLeftmostKey(){
            return removeKey(0);
        }
        //todo 移除最右边的key
        int removeRightmostKey(){
            return removeKey(keyNumber - 1);
        }
        //todo 移除指定的 index 处的 child
        Node removeChild(int index){
            Node t = children[index];
            System.arraycopy(children,index + 1,children,index,keyNumber - index);
            children[keyNumber] = null;
            return t;

        }
        //todo 移除最左边的 child
        Node removeLeftmostChild(){
            return removeChild(0);
        }
        //todo 移除最右边的 child
        Node removeRightmostChild(){
            return removeChild(keyNumber);
        }
        //todo index 孩子处左边的兄弟
        Node childLeftSibling(int index){
            return index > 0 ? children[index - 1] : null;
        }
        //todo index 孩子处右边的兄弟
        Node childRightSibling(int index){
            return index == keyNumber ? null : children[index + 1];
        }
        //todo 复制当前节点的所有 key 和 child 到 target
        void moveToTarget(Node target){
            int start = target.keyNumber;
            if(!leaf){
                if (keyNumber + 1 >= 0) {
                    System.arraycopy(children, 0, target.children, start, keyNumber + 1);
                }
            }
            for (int i = 0; i < keyNumber; i++) {
                target.keys[target.keyNumber++] = keys[i];
            }
        }
    }

    Node root;
    int t; //todo 树中节点最小度数
    final int MIN_KEY_NUMBER; //todo 最小key数目
    final int MAX_KEY_NUMBER; //todo 最大key数目

    public BTree() {
        this(2);
    }
    public BTree(int t){
        this.t = t;
        MAX_KEY_NUMBER = 2 * t - 1;
        MIN_KEY_NUMBER = t - 1;
        root = new Node(t);
    }

    //todo 是否存在
    public boolean contains(int key){
        return root.get(key) != null;
    }

    //todo 新增元素
    public void put(int key){
        doPut(root,key,null,0);
    }
    private void doPut(Node node,int key,Node parent,int index){
        int i = 0;
        while(i < node.keyNumber){
            if(node.keys[i] == key){
                return; //todo 更新
            }
            if(node.keys[i] > key){
                break; //todo 插入位置
            }
            i++;
        }
        if(node.leaf){
            node.insertKey(key,i);
        }else {
            doPut(node.children[i],key,node,i);
        }
        if(node.keyNumber == MAX_KEY_NUMBER){
            split(node,parent,index);
        }
    }

    //todo 分裂元素
    //todo 创建right节点（分裂后大于大于当前left节点的），把t以后的key和child都拷贝过去
    //todo t - 1处的key插入到parent的index处，index指left作为孩子的索引
    //todo right的节点作为parent的孩子插入到index + 1处
    private void split(Node left,Node parent,int index){
        //todo 分裂的是根节点
        if(parent == null){
            Node newRoot = new Node(t);
            newRoot.leaf = false;
            newRoot.insertChild(left,0);
            this.root = newRoot;
            parent = newRoot;
        }
        //todo 1.创建right节点（分裂后大于大于当前left节点的），把t以后的key和child都拷贝过去
        Node right = new Node(t);
        right.leaf = left.leaf;
        System.arraycopy(left.keys,t,
                right.keys,0,t - 1);
        //todo 非叶子节点的情况
        if(!left.leaf){
            System.arraycopy(left.children,t,
                    right.children,0,t);
        }
        right.keyNumber = t - 1;
        left.keyNumber = t - 1;
        //todo 2.t - 1处的key插入到parent的index处，index指left作为孩子的索引
        int mid = left.keys[t - 1];
        parent.insertKey(mid,index);
        //todo 3.right的节点作为parent的孩子插入到index + 1处
        parent.insertChild(right,index + 1);

    }

    //todo 删除元素
    //todo case 1:当前节点是叶子节点，没找到
    //todo case 2:当前节点是叶子节点，找到了
    //todo case 3:当前节点是非叶子节点，没找到
    //todo case 4:当前节点是非叶子节点，找到了
    //todo case 5:删除后key数目 < 下限 (不平衡)
    //todo case 6:当前节点是根节点
    public void remove(int key){
        doRemove(null,root,0,key);
    }
    private void doRemove(Node parent,Node node,int index,int key){
        int i = 0;  //todo 索引
        while(i < node.keyNumber) {
            if (node.keys[i] >= key) {
                break;
            }
            i++;
            //todo i 可能找到了（代表删除key的索引 或 可能没找到（代表到第i个孩子继续寻找）
            if (node.leaf) {
                //todo case 1:当前节点是叶子节点，没找到
                if (!found(node, key, i)) {
                    return;
                }//todo case 2:当前节点是叶子节点，找到了
                else {
                    node.removeKey(i);
                }
            }else {
                //todo case 3:当前节点是非叶子节点，没找到
                if (!found(node, key, i)) {
                    doRemove(node,node.children[i],i,key);
                } //todo case 4:当前节点是非叶子节点，找到了
                else {
                    //todo 找到后继key
                    Node s = node.children[i + 1];  //todo 开始查找的节点
                    while(!s.leaf){
                        s = s.children[0];
                    }
                    int sky = s.keys[0];
                    //todo 替换删除key
                    node.keys[i] = sky;
                    //todo 删除后继key
                    doRemove(node,node.children[i + 1],i + 1,sky);
                }
            }
            if(node.keyNumber < MIN_KEY_NUMBER){
                //todo 重新调整平衡
                //todo case 5:删除后key数目 < 下限 (不平衡)
                //todo case 6:当前节点是根节点
                balance(parent,node,index);
            }
        }
    }

    //todo 控制平衡的方法
    private void balance(Node parent,Node x,int i){
        //todo case 6:根节点
        if(x == root){
            if(root.keyNumber == 0 && root.children[0] != null){
                root = root.children[0];
            }
            return;
        }
        Node left = parent.childLeftSibling(i);
        Node right = parent.childRightSibling(i);
        if(left != null && left.keyNumber > MIN_KEY_NUMBER){
            //todo case 5-1:左边富裕，右旋
            //todo a 父节点中前驱key旋转下来
            x.insertKey(parent.keys[i - 1],0);
            if(!left.leaf){
                //todo b left中最大的孩子换爹
                x.insertChild(left.removeRightmostChild(),0);
            }
            //todo c left中最大的key旋转上去
            parent.keys[i - 1] = left.removeLeftmostKey();
            return;
        }
        if(right != null && right.keyNumber > MIN_KEY_NUMBER){
            //todo case 5-2:右边富裕，左旋
            //todo a 父节点中后继key旋转下来
            x.insertKey(parent.keys[i],x.keyNumber);
            if(!right.leaf){
                //todo b right中最小的孩子换爹
                x.insertChild(right.removeLeftmostChild(),x.keyNumber + 1);
            }
            //todo c right中最小的key旋转上去
            parent.keys[i] = right.removeRightmostKey();
            return;
        }
        //todo case 5-3:两边都不够，向左合并
        if(left != null){
            //todo 向左兄弟合并
            parent.removeChild(i);
            left.insertKey(parent.removeKey(i - 1),left.keyNumber);
            x.moveToTarget(left);
        }else {
            //todo 向自己合并
            parent.removeChild(i + 1);
            x.insertKey(parent.removeKey(i),x.keyNumber);
            assert right != null;
            right.moveToTarget(x);
        }
    }
    private boolean found(Node node, int key, int i) {
        return i < node.keyNumber && node.keys[i] == key;
    }

}
