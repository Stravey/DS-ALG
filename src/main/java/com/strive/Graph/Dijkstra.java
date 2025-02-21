package com.strive.Graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("all")
//todo 迪克斯特拉 单源最短路径算法 优先级队列
public class Dijkstra {

    /*
       1.将所有顶点标记为未访问。创建一个未访问顶点的集合
       2.对每个顶点分配一个临时距离值
           对于我们的初始顶点，将其设置为0
           对于所有其他顶点，将其设置为无穷大
       3.每次选择最小临时距离的未访问顶点，作为新的当前顶点
       4.对于当前顶点，遍历器所有未访问的邻居，并更新他们的临时距离为更小
       5.当前顶点的邻居处理完成后，把它从未访问集合中删除
    */

    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(new Edge(v3,9),new Edge(v2,7),new Edge(v6,14));
        v2.edges = List.of(new Edge(v4,15));
        v3.edges = List.of(new Edge(v4,11),new Edge(v6,2));
        v4.edges = List.of(new Edge(v5,6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5,9));

        List<Vertex> graph = List.of(v1,v2,v3,v4,v5,v6);

        dijkstra(graph,v1);
    }

    private static void dijkstra(List<Vertex> graph,Vertex source) {
        //todo Java中的优先级队列默认为小顶堆
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.dist));
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
            cur.visited = true;
        }

        for (Vertex v : graph) {
            System.out.println(v.name + " " + v.dist + " " + (v.prev != null ? v.prev.name : "null"));
        }
    }

    //todo 更新结点的方法
    private static void updateNeighboursDist(Vertex cur,PriorityQueue<Vertex> queue) {
        for (Edge edge : cur.edges) {
            Vertex n = edge.linked;
            if(!n.visited) {
                int dist = cur.dist + edge.weight;
                if (dist < n.dist) {
                    n.dist = dist;
                    n.prev = cur;
                    queue.offer(n);
                }
            }
        }
    }

}
