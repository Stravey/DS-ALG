package com.strive.Graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("all")
//todo Prim算法和Dijkstra算法非常像
public class Prim {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");

        v1.edges = List.of(
                new Edge(v2,2),
                new Edge(v3,4),
                new Edge(v4,1)
        );
        v2.edges = List.of(
                new Edge(v1,2),
                new Edge(v4,3),
                new Edge(v5,10)
        );
        v3.edges = List.of(
                new Edge(v1,4),
                new Edge(v4,2),
                new Edge(v6,5)
        );
        v4.edges = List.of(
                new Edge(v1,1),
                new Edge(v2,3),
                new Edge(v5,7),
                new Edge(v7,4),
                new Edge(v6,8),
                new Edge(v3,2)
        );
        v5.edges = List.of(
                new Edge(v2,3),
                new Edge(v5,7),
                new Edge(v7,4)
        );
        v6.edges = List.of(
                new Edge(v3,2),
                new Edge(v4,8),
                new Edge(v7,1)
        );
        v7.edges = List.of(
                new Edge(v4,4),
                new Edge(v5,6),
                new Edge(v6,1)
        );

        List<Vertex> graph = List.of(v1,v2,v3,v4,v5,v6,v7);

        prim(graph,v1);

    }

    private static void prim(List<Vertex> graph,Vertex source){
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v-> v.dist));
        source.dist = 0;
        for (Vertex v : graph) {
            queue.offer(v);
        }

        while (!queue.isEmpty()) {
            //todo 3.选取当前顶点
            Vertex cur = queue.peek();
            //todo 4.更新当前顶点邻居距离
            if(!cur.visited){
                updateNeighboursDist(cur,queue);
                cur.visited = true;
            }
            //todo 5.移除当前顶点
            queue.remove(cur);
        }

        for (Vertex v : graph) {
            System.out.println(v.name + " " + v.dist + " " + (v.prev != null ? v.prev.name : "null"));
        }
    }

    private static void updateNeighboursDist(Vertex cur,PriorityQueue<Vertex> queue) {
        for (Edge edge : cur.edges) {
            Vertex n = edge.linked;
            if(!n.visited) {
                int dist = edge.weight;
                if (dist < n.dist) {
                    n.dist = dist;
                    n.prev = cur;
                    queue.offer(n);
                }
            }
        }
    }
}
