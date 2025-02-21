package com.strive.DP;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BellmanFord {
    static class Edge{
        int from; //todo 相邻的点
        int to;
        int weight; //todo 权重 即值


        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }
    static class Vertex{
        String name; //todo 顶点的名字
        List<com.strive.Graph.Edge> edges; //todo 边的List集合
        boolean visited; //todo 访问过的结点
        int inDegree; //todo 入度
        int status; //todo 初始 0-为访问 1-访问中 2-访问过
        int dist = INF; //todo 距离
        static final Integer INF = Integer.MAX_VALUE;
        com.strive.Graph.Vertex prev = null; //todo 记录前一个

        public Vertex(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        @Override
        public String toString(){
            return name + '(' + dist + ')';
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            com.strive.Graph.Vertex vertex = (com.strive.Graph.Vertex) object;
            return Objects.equals(name, vertex.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }


    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");


        List<Edge> edges = List.of(
                new Edge(6,5,9),
                new Edge(4,5,6),
                new Edge(1,6,14),
                new Edge(3,6,2),
                new Edge(3,4,11),
                new Edge(2,4,15),
                new Edge(1,3,9),
                new Edge(1,2,7)
        );

        int[] dp = new int[7];
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        print(dp);
        for (int i = 0; i < 5; i++) {
            for (Edge e : edges) {
                if (dp[e.from] != Integer.MAX_VALUE) {
                    dp[e.to] = Integer.min(dp[e.to], dp[e.from] + e.weight);
                }
            }
        }
        print(dp);
    }

    static void print(int[] dp){
        System.out.println(Arrays.stream(dp)
                .mapToObj(i -> i == Integer.MAX_VALUE ? "X" : String.valueOf(i))
                .collect(Collectors.joining(",","[","]"))
        );
    }
}
