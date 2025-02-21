package com.strive.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//todo 克鲁斯卡尔算法
public class Kruskal {
    static class Edge implements Comparable<Edge> {
        List<Vertex> vertices;
        int start;
        int end;
        int weight;
        public Edge(List<Vertex> vertices,int start,int end,int weight){
            this.vertices = vertices;
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        public Edge(int start,int end,int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight,o.weight);
        }
        @Override
        public String toString(){
            return vertices.get(start).name + "<->" + vertices.get(end).name + "(" + weight + ")";
        }
    }
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        List<Vertex> vertices = List.of(v1,v2,v3,v4,v5,v6,v7);

        PriorityQueue<Edge> queue = new PriorityQueue<>(List.of(
                new Edge(vertices,0,1,2),
                new Edge(vertices,0,2,4)

        ));

        kruskal(vertices.size(),queue);

    }
    static void kruskal(int size, PriorityQueue<Edge> queue) {
        List<Edge> list = new ArrayList<>();
        DisjointSet set = new DisjointSet(size);
        while (list.size() < size - 1) {
            Edge poll = queue.poll();
            assert poll != null;
            int i = set.find(poll.start);
            int j = set.find(poll.end);
            if(i != j){
                list.add(poll);
                set.union(i,j); //两个顶点相交
            }
        }
        for (Edge edge : list) {
            System.out.println(edge);
        }
    }
}
