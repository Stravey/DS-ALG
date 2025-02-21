package com.strive.Tree;

@SuppressWarnings("all")
public class AVLTree {
    static class AVLNode{
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;

        public AVLNode(int key){
            this.key = key;
        }
        public AVLNode(int key,Object value){
            this.key = key;
            this.value = value;
        }
        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //todo 求节点的高度
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    //todo 更新节点高度（新增、删除、旋转）
    private void updateHeight(AVLNode node){
        node.height = Integer.max(height(node.left),height(node.right));
    }

    //todo 判断高度差是否为1 平衡因子（左子树高度 - 右子树高度） balance factor
    private int bf(AVLNode node){
        return height(node.left) - height(node.right);
    }
    //todo 返回 0 -1 1 平衡的
    //todo 返回  >1（左边比较高）  或   <-1（右边比较高）  不平衡的


    //todo 四种失衡情况
    //todo LL LR RL RR
    /*
    LL
         失衡节点的bf > 1，左边更高
         失衡节点的左子树 bf >= 0,左边更高或等高
         通过一次右旋 失衡节点
    LR
         失衡节点的bf > 1，左边更高
         失衡节点的右子树 bf < 0,右边更高或等高
         通过两次旋转 左子树向左旋转 失衡节点向右旋转
    RL
         失衡节点的bf < -1，右边更高
         失衡节点的左子树 bf > 0,左边更高或等高
         通过两次旋转 右子树向右旋转 失衡节点向左旋转
    RR
         失衡节点的bf < -1，右边更高
         失衡节点的左子树 bf <= 0,右边更高或等高
         通过一次左旋 失衡节点
    */
    //todo 参数 要旋转的节点   返回值 新的根节点
    private AVLNode rightRotate(AVLNode red){
        AVLNode yellow = red.left;
        AVLNode green = yellow.right;
        yellow.right = red;       //黄色要上去
        red.left = green;         //换位
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    //todo 参数 要旋转的节点   返回值 新的根节点
    private AVLNode leftRotate(AVLNode red){
        AVLNode yellow = red.right;
        AVLNode green = yellow.left;
        yellow.left = red;
        red.right = green;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    //todo 先左旋左子树，再右旋根节点
    private AVLNode leftRightRotate(AVLNode node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    //todo 先右旋左子树，再左旋根节点
    private AVLNode rightLeftRotate(AVLNode node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    //todo 判断树是否失衡 若失衡重新平衡
    private AVLNode balance(AVLNode node){
        if(node == null){
            return null;
        }
        int bf = bf(node); //todo 平衡因子
        if(bf > 1 && bf(node.left) >= 0){
            //todo LL
            return leftRotate(node);
        } else if (bf > 1 && bf(node.left) < 0) {
            //todo LR
            return leftRightRotate(node);
        } else if (bf < -1 && bf(node.right) > 0) {
            //todo RL
            return rightLeftRotate(node);
        } else if (bf < -1 && bf(node.right) <= 0) {
            //todo RR
            return rightRotate(node);
        }
        return node;
    }

    AVLNode root;

    //todo 增加元素
    private void put(int key,Object value){
        root = doPut(root,key,value);
    }
    private AVLNode doPut(AVLNode node,int key,Object value){
        //1.找到空位，创建新节点
        if(node == null){
            return new AVLNode(key,value);
        }
        //2.key 已经存在 更新
        if(key == node.key){
            node.value = value;
            return node;
        }
        //3.继续查找
        if(key < node.key){
            node.left = doPut(node.left,key,value); //向左
        }else {
            node.right = doPut(node.right,key,value); //向右
        }
        updateHeight(node);
        return balance(node);
    }

    //todo 删除元素
    public void remove(int key){
        doRemove(root,key);
    }
    private AVLNode doRemove(AVLNode node,int key){
        //1.node为空
        if(node == null){
            return null;
        }
        //2.没找到key
        if(key < node.key){
            node.left = doRemove(node.left,key);
        } else if (key > node.key) {
            node.right = doRemove(node.right,key);
        } else {
            //3.找到key  3种情况：没有//一个孩子//两个孩子都有
            if(node.left == null && node.right == null){
                return null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                AVLNode s = node.right;
                while(s.left != null){
                    s = s.left;
                }
                //s 后继节点
                s.right = doRemove(node.right,s.key);
                s.left = node.left;
                node = s;
            }
        }
        //4.更新高度
        updateHeight(node);
        //5.balance
        return balance(node);
    }
}