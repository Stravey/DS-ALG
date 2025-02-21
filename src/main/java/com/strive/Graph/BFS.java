package com.strive.Graph;

import java.util.LinkedList;
import java.util.List;

//todo 广度优先遍历 队列
public class BFS {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(
                new Edge(v3,9),
                new Edge(v2,7),
                new Edge(v6,14)
        );
        v2.edges = List.of(new Edge(v4,15));
        v3.edges = List.of(
                new Edge(v4,11),
                new Edge(v6,2)
        );
        v4.edges = List.of(new Edge(v5,6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5,9));

        bfs(v1);
    }

    private static void bfs(Vertex v) {
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.offer(v);
        v.visited = true;
        while(!queue.isEmpty()){
            Vertex pop = queue.pop();
            System.out.println(pop.name);
            for (Edge edge : pop.edges) {
                if(!edge.linked.visited) {
                    edge.linked.visited = true;
                    queue.offer(edge.linked);
                }
            }
        }
    }
}
