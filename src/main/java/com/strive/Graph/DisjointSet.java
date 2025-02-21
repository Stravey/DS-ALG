package com.strive.Graph;

import java.util.Arrays;

//todo 并查集
public class DisjointSet {
    int[] s;
    int[] size;

    public DisjointSet(int size){
        s = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            s[i] = i;
            this.size[i] = 1;
        }
    }

    //todo 优化：路径压缩
    public int find(int x){
        if(x == s[x]){
            return x;
        }
        return s[x] = find(s[x]);
    }

    //todo 优化 让两个集合“相交”
    public void union(int x,int y){
        /* //x少 y是老大
        if (size[x] < size[y]) {
            s[x] = y;
            size[y] = size[x] + size[y];
        }
        //y少 x是老大
        else {
            s[y] = x;
            size[x] = size[x] + size[y];
        }*/

        if(size[x] < size[y]) {
            int t = x;
            x = y;
            y = t;
        }
        s[y] = x;
        size[x] = size[x] + size[y];
    }

    @Override
    public String toString() {
        return Arrays.toString(s);
    }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(7);
        System.out.println(set);
        //索引对应顶点
        //元素是用来表示与之有关系的顶点
        /* int x = set.find(0);
        int y = set.find(3);
        System.out.println("老大分别为：" + x + " " + y);
        if (x != y) {
            set.union(x,y);
        }
        System.out.println(set);

        x = set.find(5);
        y = set.find(6);
        System.out.println("老大分别为：" + x + " " + y);
        if(x != y) {
            set.union(5,6);
        }
        System.out.println(set);

        x = set.find(0);
        y = set.find(1);
        System.out.println("老大分别为：" + x + " " + y);
        if(x != y) {
            set.union(0,1);
        }
        System.out.println(set);

        x = set.find(2);
        y = set.find(3);
        System.out.println("老大分别为：" + x + " " + y);
        if(x != y) {
            set.union(2,3);
        }
        System.out.println(set);

        x = set.find(0);
        y = set.find(2);
        System.out.println("老大分别为：" + x + " " + y);
        if(x != y) {
            set.union(0,2);
        }
        System.out.println(set);*/

        set.union(0,1);
        set.union(1,2);
        set.union(2,3);
        set.union(3,4);
        set.union(4,5);
        set.union(5,6);
        System.out.println(set);
        set.find(2);
        System.out.println(set);
    }
}
