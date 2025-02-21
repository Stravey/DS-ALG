package com.strive.Tree;

@SuppressWarnings("all")
public class RedBlackTree {
    enum Color {
        RED, BLACK;
    }

    private Node root;

    private static class Node {
        int key;
        Object value;
        Node left;
        Node right;
        Node parent;  //todo 父节点
        Color color = Color.RED;   //todo 颜色

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        //todo 是否为左孩子
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }
        //todo 叔叔
        Node uncle() {
            if(parent == null || parent.parent == null){
                return null;
            }
            if(parent.isLeftChild()){
                return parent.parent.right;
            }else {
                return parent.parent.left;
            }
        }
        //todo 兄弟
        Node sibling(){
            if(parent == null){
                return null;
            }
            if(this.isLeftChild()){
                return parent.right;
            }else {
                return parent.left;
            }
        }
    }

    //todo 判断节点是否为红色
    boolean isRed(Node node){
        return node != null && node.color == Color.RED;
    }
    //todo 判断节点是否为黑色
    boolean isBlack(Node node){
        return node == null || node.color == Color.BLACK;
    }

    //todo 右旋 1.parent处理 2.旋转后新根的父子关系
    private void rightRotate(Node pink){
        Node parent = pink.parent;
        Node yellow = pink.left;
        Node green = yellow.right;
        if(green != null){
            green.parent = pink;
        }
        yellow.right = pink;
        yellow.parent = parent;
        pink.left = green;
        pink.parent = yellow;
        if(parent == null){
            root = yellow;
        } else if(parent.left == pink){
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    //todo 左旋 1.parent处理 2.旋转后新根的父子关系
    private void leftRotate(Node pink){
        //todo 修改
        Node parent = pink.parent;
        Node yellow = pink.left;
        Node green = yellow.right;
        if(green != null){
            green.parent = pink;
        }
        yellow.right = pink;
        yellow.parent = parent;
        pink.left = green;
        pink.parent = yellow;
        if(parent == null){
            root = yellow;
        } else if(parent.left == pink){
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    //todo 新增或更新红黑树节点
    //todo 正常增、遇到红红不平衡进行调整
    public void put(int key,Object value){
        Node p = root;
        Node parent = null;
        while(p != null){
            if(key < p.key){
                p = p.left;
            } else if (p.key > key) {
                p = p.right;
            } else {
               p.value = value;  //todo 更新
               return;
            }
        }
        Node inserted = new Node(key,value);
        if(parent == null){
            root = inserted;
        } else if (key < parent.key) {
            parent.left = inserted;
            inserted.parent = parent;
        } else {
            parent.right = inserted;
            inserted.parent = parent;
        }
        fixDoubleRed(root);
    }
    //todo 调整红红不平衡 共有四种情况
    /*
      case 1:插入节点为根节点，将根节点变黑
      case 2:插入节点的父亲若为黑色，树的红黑性质不变，无需调整
      插入节点的父亲若为红色，触发红红相邻 (此时要通过变色或旋转来解决问题)
      case 3:叔叔为红色
      case 4:叔叔为黑色
    * */
    void fixDoubleRed(Node x){
        //case 1:插入节点为根节点，将根节点变黑
        if(x == root){
            x.color = Color.BLACK;
            return;
        }
        //case 2:插入节点的父亲若为黑色，树的红黑性质不变，无需调整
        if(x != null) {
            isBlack(x.parent);
            return;
        }
        //todo 插入节点的父亲若为红色，触发红红相邻
        //todo case 3:叔叔为红色
        //todo 通过变色
        //todo 具体步骤:  父亲变为黑色，为了保证黑色平衡，连带的叔叔也变为黑色
        //              祖父如果是黑色不变，会造成这颗子树黑色过多，因此祖父节点变为红色
        //              祖父如果变成红色，可能会接替触发红红相邻，因此对祖父进行递归调整
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandparent = parent.parent;
        if(isRed(uncle)){
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandparent.color = Color.RED;
            fixDoubleRed(grandparent);
            return;
        }
        //插入节点的父亲若为红色，触发红红相邻
        //case 4:叔叔为黑色
        /*
           四种情况：1.父亲为左孩子，插入节点也是左孩子，此时即LL不平衡
                   2.父亲为左孩子，插入节点是右孩子，此时即LR不平衡
                   3.父亲为右孩子，插入节点也是右孩子，此时即RR不平衡
                   4.父亲为右孩子，插入节点是左孩子，此时即RL不平衡
        */
        //通过旋转
        //todo case1:1.父亲为左孩子，插入节点也是左孩子，此时即LL不平衡
        if(parent.isLeftChild() && x.isLeftChild()){
            parent.color = Color.BLACK;
            grandparent.color = Color.RED;
            rightRotate(grandparent);
        }//todo case2:2.父亲为左孩子，插入节点是右孩子，此时即LR不平衡
        else if(parent.isLeftChild() && !x.isLeftChild()){
            leftRotate(parent);
            x.color = Color.BLACK;
            grandparent.color = Color.RED;
            rightRotate(grandparent);
        }//todo case3:3.父亲为右孩子，插入节点也是右孩子，此时即RR不平衡
        else if (!parent.isLeftChild() && !x.isLeftChild()) {
            parent.color = Color.BLACK;
            grandparent.color = Color.RED;
            leftRotate(grandparent);
        }//todo case4:4.父亲为右孩子，插入节点是左孩子，此时即RL不平衡
        else {
            rightRotate(parent);
            x.color = Color.BLACK;
            grandparent.color = Color.RED;
            leftRotate(grandparent);
        }
    }

    //todo 删除红黑树节点
    //todo 正常删、李代桃僵(和swap函数相似)、遇到黑黑不平衡进行调整
    public void remove(int key){
        Node deleted = find(key);
        if(deleted == null) {
            return;
        }
        doRemove(deleted);
    }
    //todo 处理黑黑不平衡的情况
    //todo 当删除节点和剩下节点都是黑，就触发了以下三种情况
    //todo case 3:删除节点或剩余节点的兄弟为红，此时两个侄子定为黑
    //todo case 4:删除节点或剩余节点的兄弟、和兄弟孩子都为黑
    //todo case 5:删除节点的兄弟为黑，至少一个红侄子
    private void fixDoubleBlack(Node x){
        if(x == root){
            return;
        }
        Node parent = x.parent;
        Node sibling = x.sibling();
        //todo case 3:删除节点或剩余节点的兄弟为红，此时两个侄子定为黑
        if(isRed(sibling)){
            if(x.isLeftChild()){
                leftRotate(parent);
            }else {
                rightRotate(parent);
            }
            parent.color = Color.RED;
            sibling.color = Color.BLACK;
            fixDoubleBlack(x);
            return;
        }
        //todo 兄弟是黑色
        if(sibling != null){
            //todo case 4:删除节点或剩余节点的兄弟、和兄弟孩子都为黑
            //todo 将兄弟变红，目的是将删除节点和兄弟那边的黑色高度同时减少1
            //todo 如果父亲是红，则需将父亲变为黑，避免红红，此时路径黑节点书目不变
            //todo 如果父亲是黑，说明这条路径少了一个黑，再次让父节点出发双黑递归调用
            if(isBlack(sibling.left) && isBlack(sibling.right)){
                sibling.color = Color.RED;
                if(isRed(parent)){
                    parent.color = Color.BLACK;
                }else {
                    fixDoubleBlack(parent);
                }
            }
            //todo case 5:删除节点的兄弟为黑，至少一个红孩子
            //todo 四种情况
            //todo 如果兄弟是左孩子 左侄子为红 LL不平衡
            //todo 如果兄弟是左孩子 右侄子为红 LR不平衡
            //todo 如果兄弟是右孩子 右侄子为红 RR不平衡
            //todo 如果兄弟是右孩子 左侄子为红 RL不平衡
            else {
                //todo 如果兄弟是左孩子 左侄子为红 LL不平衡
                if(sibling.isLeftChild() && isRed(sibling.left)){
                    rightRotate(parent);
                    sibling.left.color = Color.RED;
                    sibling.color = parent.color;
                }//todo 如果兄弟是左孩子 右侄子为红 LR不平衡
                else if (sibling.isLeftChild() && isRed(sibling.right)) {
                    sibling.right.color = parent.color;
                    leftRotate(sibling);
                    rightRotate(parent);
                }//todo 如果兄弟是右孩子 右侄子为红 RR不平衡
                else if (!sibling.isLeftChild() && isRed(sibling.right)) {
                    sibling.left.color = parent.color;
                    rightRotate(sibling);
                    leftRotate(parent);
                }//todo 如果兄弟是右孩子 左侄子为红 RL不平衡
                else if (!sibling.isLeftChild() && isRed(sibling.left)) {
                    leftRotate(parent);
                    sibling.right.color = Color.BLACK;
                    sibling.color = parent.color;
                }
                parent.color = Color.BLACK;
            }
        }else {
            fixDoubleBlack(parent);
        }
    }
    private void doRemove(Node deleted) {
        Node replaced = findReplaced(deleted);
        Node parent = deleted.parent;
        //todo 没有孩子
        if(replaced == null) {
            //todo case 1 : 删除的为根节点
            /* 删完了，直接将root == null
               如果他有一个孩子，用剩余节点替换了根节点的key,value,根节点孩子 = null,颜色保持黑色不变
            */
            if(deleted == root){
                root = null;
            }//todo case 2 : 删除的为根节点 同时为没有孩子的情况
            else {
                if(isBlack(deleted)){
                    //复杂调整
                    fixDoubleBlack(deleted);
                }else {
                    //红色叶子，无需处理
                }
                if(deleted.isLeftChild()){
                    parent.left = null;
                }else {
                    parent.right = null;
                }
                deleted.parent = null;
            }
            return;
        }
        //todo 有一个孩子
        if(deleted.left == null || deleted.right == null) {
            //todo case 1 : 删除的为根节点
            /* 删完了，直接将root == null
               如果他有一个孩子，用剩余节点替换了根节点的key,value,根节点孩子 = null,颜色保持黑色不变
            */
            if(deleted == root){
                root.key = replaced.key;
                root.value = replaced.value;
                root.left = root.right = null;
            }//todo case 2 : 删除的不是根节点 同时只有一个孩子的情况
            else {
                //todo 把deleted删除了
                if(deleted.isLeftChild()){
                    parent.left = replaced;
                }else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null;
                if(isBlack(deleted) && isBlack(replaced)){
                    //复杂处理
                    fixDoubleBlack(replaced);
                }else{
                    //todo case 2 删的是黑，剩下的是红色，剩下这个红节点变黑
                    replaced.color = Color.BLACK;
                }
            }
            return;
        }
        //todo case 0 : 有两个孩子 转换成 只有一个孩子 或 没有孩子的情况
        int t = deleted.key;
        deleted.key = replaced.key;
        replaced.key = t;
        Object v = deleted.value;
        deleted.value = replaced.value;
        replaced.value = t;
        doRemove(replaced);
    }

    //todo 查找删除节点
    Node find(int key){
        Node p = root;
        if(p != null){
            if(key < p.key){
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }
    //todo 查找剩余节点
    Node findReplaced(Node deleted){
        if(deleted.left == null && deleted.right == null){
            return null;
        }
        if(deleted.left == null){
            return deleted.right;
        }
        if(deleted.right == null){
            return deleted.left;
        }
        Node s = deleted.right;
        while(s.left != null){
            s = s.left;
        }
        return s;
    }
}
