package com.strive.Tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//todo 用满二叉树结构编码  向左走 0，向右走 1  走到叶子字符，累积起来的 0 和 1 就是该字符的二进制编码
//todo 哈夫曼树 哈夫曼编码
public class HuffmanTree {
    /*
       哈夫曼树构建过程
       1.将统计了出现频率的字符，放入优先级队列
       2.每次出队两个频次最低的元素，给他俩找个爹
       3.把爹重新放入队列，重复2~3
       4.当队列只剩一个元素时，Huffman树构建完成
     */

    static class Node{
        Character ch; //字符
        int freq; //频次
        Node left;
        Node right;
        String code; //编码

        public Node(Character ch) {
            this.ch = ch;
        }

        public Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public int freq() {
            return freq;
        }

        boolean ifLeaf(){
            return left == null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", freq=" + freq +
                    '}';
        }
    }

    String str;
    Map<Character,Node> map = new HashMap<>();
    Node root;

    public HuffmanTree(String str) {
        this.str = str;
        //todo 1.统计每个字符的频次
        char[] chars = str.toCharArray();
        for(char c : chars) {
            /*if(!map.containsKey(c)) {
                map.put(c,new Node(c));
            }
            Node node = map.get(c);
            node.freq++;*/
            Node node = map.computeIfAbsent(c,Node::new);
            node.freq++;
        }
        for(Node node : map.values()) {
            System.out.println(node);
        }
        //todo 2.每次出队两个频次最低的元素，给他俩找个爹
        PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(Node::freq)
        );
        queue.addAll(map.values());
        while(queue.size() >= 2) {
            Node x = queue.poll();
            Node y = queue.poll();
            assert y != null;
            int freq = x.freq + y.freq;
            queue.offer(new Node(freq,x,y));
        }
        Node root = queue.poll();
        System.out.println(root);
        //todo 3.计算每个字符的编码
        if(root == null) {
            return;
        }
        int sum = dfs(root,new StringBuilder());
        for (Node node : map.values()) {
            System.out.println(node + " " + node.code);
        }
        System.out.println(sum);
    }

    private int dfs(Node node, StringBuilder code) {
        int sum = 0;
        if(node.ifLeaf()) {
            //找到编码
            node.code = code.toString();
            sum = node.freq * code.length();
        } else {
            sum += dfs(node.left,code.append("0"));
            sum += dfs(node.right,code.append("1"));
        }
        if(!code.isEmpty()) {
            code.deleteCharAt(code.length() - 1);
        }
        return sum;
    }

    //编码
    public String encode() {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            sb.append(map.get(c).code);
        }
        return sb.toString();
    }

    //解码
    public String decode(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Node node = root;
        while (i < chars.length) {
            if(!node.ifLeaf()) {
                if(chars[i] == '0') {
                    //向左走
                    node = node.left;
                } else if (chars[i] == '1') {
                    //向右走
                    node = node.right;
                }
                i++;
            }
            if(node.ifLeaf()) {
                sb.append(node.ch);
                node = root;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree("abbccccccc");
        String encoded = tree.encode();
        System.out.println(encoded);
        System.out.println(tree.decode(encoded));
    }

}
