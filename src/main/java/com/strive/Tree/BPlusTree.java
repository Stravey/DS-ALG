package com.strive.Tree;

import org.junit.Test;

import java.util.*;

@SuppressWarnings("all")
public class BPlusTree {

    private static final int M = 4;

    private static final int MIN_KEYS = (int) Math.ceil(M / 2.0) - 1;

    private static abstract class Node{
        List<Integer> keys = new ArrayList<>();
        abstract Object getValue(int key);
        abstract void insert(int key,String value);
        abstract void remove(int key);
        abstract int getFirstLeafKey();
    }

    // 抽象节点类
    private static class InternalNode extends Node{
        List<Node> children = new ArrayList<>();

        @Override
        Object getValue(int key) {
           int idx = Collections.binarySearch(keys,key);
           int childIndex = idx >= 0 ? idx + 1 :-idx - 1;
           return children.get(childIndex).getValue(key);

        }

        @Override
        void insert(int key, String value) {
            Node child = getChild(key);
            child.insert(key,value);
            if(child.keys.size() > M - 1) {
                splitChild(child);
            }
        }

        private Node getChild(int key) {
            int idx = Collections.binarySearch(keys,key);
            int childIndex = idx >= 0 ? idx + 1 :-idx - 1;
            return children.get(childIndex);
        }

        private void splitChild(Node child) {
            int idx = children.indexOf(child);
            Node newChild;

            if(child instanceof LeafNode) {
                LeafNode leaf = (LeafNode) child;
                LeafNode newLeaf = new LeafNode();

                int mid = leaf.keys.size() / 2;
                newLeaf.keys.addAll(leaf.keys.subList(mid,leaf.keys.size()));
                newLeaf.values.addAll(leaf.values.subList(mid,leaf.values.size()));
                leaf.keys.subList(mid,leaf.keys.size()).clear();
                leaf.values.subList(mid,leaf.values.size()).clear();

                newLeaf.next = leaf.next;
                leaf.next = newLeaf;
                newChild = newLeaf;
            } else {
                InternalNode internal = (InternalNode) child;
                InternalNode newInternal = new InternalNode();

                int mid = internal.keys.size() / 2;
                int promoteKey = internal.keys.get(mid);
                newInternal.keys.addAll(internal.keys.subList(mid + 1,internal.keys.size()));
                newInternal.children.addAll(internal.children.subList(mid + 1,internal.children.size()));
                internal.keys.subList(mid,internal.keys.size()).clear();
                internal.children.subList(mid,internal.children.size()).clear();
                newChild = newInternal;
            }
            int promoteKey = child.keys.get(child.keys.size() - 1);
            if(idx == keys.size()) {
                keys.add(promoteKey);
                children.add(newChild);
            } else {
                keys.add(idx,promoteKey);
                children.add(idx + 1,newChild);
            }
        }

        @Override
        void remove(int key) {
            int idx = Collections.binarySearch(keys,key);
            int childIndex = idx >= 0 ? idx + 1 :-idx - 1;
            Node child = children.get(childIndex);
            child.remove(key);
            if(child.keys.size() < MIN_KEYS) {
                handShortChild(childIndex);
            }
        }

        private void handShortChild(int childIndex) {
            if(childIndex > 0 && children.get(childIndex - 1).keys.size() < MIN_KEYS) {
                borrowFromLeft(childIndex);
            } else if(childIndex < children.size() - 1 && children.get(childIndex + 1).keys.size() > MIN_KEYS) {
                borrowFromRight(childIndex);
            } else {
                if (childIndex > 0) {
                    mergeChildren(childIndex - 1);
                } else {
                    mergeChildren(childIndex);
                }
            }
        }

        private void borrowFromLeft(int childIndex) {
            Node child = children.get(childIndex);
            Node leftSibling = children.get(childIndex - 1);

            if(child instanceof LeafNode) {
                LeafNode leaf = (LeafNode) child;
                LeafNode leftLeaf = (LeafNode) leftSibling;
                int lastKey = leftLeaf.keys.remove(leftLeaf.keys.size() - 1);
                String lastValue = leftLeaf.values.remove(leftLeaf.values.size() - 1);
                leaf.keys.add(0,lastKey);
                leaf.values.add(0,lastValue);
                keys.set(childIndex - 1,leftLeaf.keys.get(leftLeaf.keys.size() - 1));
            } else {
                InternalNode internal = (InternalNode) child;
                InternalNode leftInternal = (InternalNode) leftSibling;
                Node lastChild = leftInternal.children.remove(leftInternal.children.size() - 1);
                int borrowKey = leftInternal.keys.remove(leftInternal.keys.size() - 1);

                internal.keys.add(0,keys.get(childIndex - 1));
                internal.children.add(0,lastChild);

                keys.set(childIndex - 1,borrowKey);
            }
        }

        private void borrowFromRight(int childIndex) {
            Node child = children.get(childIndex);
            Node rightSibling = children.get(childIndex + 1);

            if (child instanceof LeafNode) {
                LeafNode leaf = (LeafNode) child;
                LeafNode rightLeaf = (LeafNode) rightSibling;

                // 从右兄弟移动第一个键值对
                int firstKey = rightLeaf.keys.remove(0);
                String firstValue = rightLeaf.values.remove(0);

                leaf.keys.add(firstKey);
                leaf.values.add(firstValue);

                // 更新父节点键
                keys.set(childIndex, leaf.keys.get(leaf.keys.size() - 1));
            } else {
                InternalNode internal = (InternalNode) child;
                InternalNode rightInternal = (InternalNode) rightSibling;

                // 从右兄弟移动第一个子节点
                Node firstChild = rightInternal.children.remove(0);
                int borrowKey = rightInternal.keys.remove(0);

                internal.keys.add(keys.get(childIndex));
                internal.children.add(firstChild);

                // 更新父节点键
                keys.set(childIndex, borrowKey);
            }
        }

        private void mergeChildren(int leftIndex) {
            Node left = children.get(leftIndex);
            Node right = children.get(leftIndex + 1);
            if(left instanceof LeafNode) {
                LeafNode leftLeaf = (LeafNode) left;
                LeafNode rightLeaf = (LeafNode) right;

                leftLeaf.keys.addAll(rightLeaf.keys);
                leftLeaf.values.addAll(rightLeaf.values);
                leftLeaf.next = rightLeaf.next;
            } else {
                InternalNode leftInternal = (InternalNode) left;
                InternalNode rightInternal = (InternalNode) right;
                leftInternal.keys.add(keys.get(leftIndex));
                leftInternal.keys.addAll(rightInternal.keys);
                leftInternal.children.addAll(rightInternal.children);
            }
            keys.remove(leftIndex);
            children.remove(leftIndex);
        }

        @Override
        int getFirstLeafKey() {
            return children.get(0).getFirstLeafKey();
        }
    }

    // 叶子节点类
    private static class LeafNode extends Node{
        List<String> values = new ArrayList<>();
        LeafNode next;

        @Override
        Object getValue(int key) {
            int idx = Collections.binarySearch(keys,key);
            return idx >= 0 ? values.get(idx) : null;
        }

        @Override
        void insert(int key, String value) {
            int idx = Collections.binarySearch(keys, key);
            int insertPos = idx >= 0 ? idx : -idx - 1;
            if (idx >= 0) {
                values.set(idx, value);
            } else {
                keys.add(insertPos, key);
                values.add(insertPos, value);
            }
        }

        @Override
        void remove(int key) {
            int idx = Collections.binarySearch(keys,key);
            if(idx >= 0) {
                keys.remove(idx);
                values.remove(idx);
            }
        }

        @Override
        int getFirstLeafKey() {
            return keys.get(0);
        }
    }


    private Node root;
    private LeafNode firstLeaf;

    public BPlusTree() {
        root = new LeafNode();
        firstLeaf = (LeafNode) root;
    }

    // 插入操作
    public void insert(int key, String value) {
        root.insert(key, value);

        // 检查根节点是否需要分裂
        if (root.keys.size() > M - 1) {
            InternalNode newRoot = new InternalNode();
            newRoot.children.add(root);
            newRoot.splitChild(root);
            root = newRoot;
        }
    }

    // 查找操作
    public String get(int key) {
        return (String) root.getValue(key);
    }

    // 删除操作
    public void remove(int key) {
        root.remove(key);

        // 如果根节点是内部节点且只有一个子节点，降低树高
        if (root instanceof InternalNode && ((InternalNode) root).children.size() == 1) {
            root = ((InternalNode) root).children.get(0);
        }
    }

    // 范围查询
    public Map<Integer, String> rangeQuery(int startKey, int endKey) {
        Map<Integer, String> result = new LinkedHashMap<>();
        LeafNode node = findLeafNode(startKey);

        while (node != null) {
            for (int i = 0; i < node.keys.size(); i++) {
                int key = node.keys.get(i);
                if (key > endKey) return result;
                if (key >= startKey) {
                    result.put(key, node.values.get(i));
                }
            }
            node = node.next;
        }
        return result;
    }

    // 辅助方法：找到包含指定键的叶子节点
    private LeafNode findLeafNode(int key) {
        Node node = root;
        while (node instanceof InternalNode) {
            InternalNode internal = (InternalNode) node;
            int idx = Collections.binarySearch(internal.keys, key);
            int childIndex = idx >= 0 ? idx + 1 : -idx - 1;
            node = internal.children.get(childIndex);
        }
        return (LeafNode) node;
    }

    // 打印树结构（用于调试）
    public void printTree() {
        printNode(root, 0);
    }

    private void printNode(Node node, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) indent.append("  ");

        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode) node;
            System.out.println(indent + "Leaf: " + leaf.keys);
        } else {
            InternalNode internal = (InternalNode) node;
            System.out.println(indent + "Internal: " + internal.keys);
            for (Node child : internal.children) {
                printNode(child, level + 1);
            }
        }
    }


    @Test
    public void test() {
        BPlusTree tree = new BPlusTree();

        // 插入测试
        tree.insert(10, "A");
        tree.insert(20, "B");
        tree.insert(30, "C");
        tree.insert(40, "D");
        tree.insert(50, "E");
        tree.insert(60, "F");

        System.out.println("After insertions:");
        tree.printTree();

        // 查找测试
        System.out.println("\nValue for key 30: " + tree.get(30));
        System.out.println("Value for key 35: " + tree.get(35));

        // 范围查询测试
        System.out.println("\nRange query [25, 45]:");
        Map<Integer, String> result = tree.rangeQuery(25, 45);
        result.forEach((k, v) -> System.out.println(k + " -> " + v));

        // 删除测试
        tree.remove(30);
        tree.remove(40);
        System.out.println("\nAfter removing 30 and 40:");
        tree.printTree();
    }

}
