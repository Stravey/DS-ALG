package com.strive.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//todo 拓扑排序  不能有环
public class TopologicalSort {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("网页基础");
        Vertex v2 = new Vertex("Java基础");
        Vertex v3 = new Vertex("JavaWeb");
        Vertex v4 = new Vertex("Spring框架");
        Vertex v5 = new Vertex("微服务框架");
        Vertex v6 = new Vertex("数据库");
        Vertex v7 = new Vertex("实战项目");

        v1.edges = List.of(new Edge(v3));
        v2.edges = List.of(new Edge(v3));
        v3.edges = List.of(new Edge(v4));
        v4.edges = List.of(new Edge(v4));
        v5.edges = List.of(new Edge(v5));
        v6.edges = List.of(new Edge(v7));
        v7.edges = List.of();

        List<Vertex> graph = List.of(v1,v2,v3,v4,v5,v6,v7);
        //todo 1.统计每个顶点的入度
        for (Vertex v : graph) {
            for (Edge edge : v.edges) {
                edge.linked.inDegree++;
            }
        }
        for (Vertex vertex : graph) {
            System.out.println(vertex.name + " " + vertex.inDegree);
        }
        //todo 2.将入度为0的顶点加入队列
        LinkedList<Vertex> queue = new LinkedList<>();
        for (Vertex v : graph) {
            if(v.inDegree == 0){
                queue.offer(v);
            }
        }
        //todo 3.队列中不断移除顶点，每移除一个顶点，把它相邻的顶点入度减1，若减到0则入队
        //todo 判断拓扑排序里是否有环
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Vertex poll = queue.poll();
            //System.out.println(poll.name);
            result.add(poll.name);
            for (Edge edge : poll.edges) {
                edge.linked.inDegree--;
                if(edge.linked.inDegree == 0){
                    queue.offer(edge.linked);
                }
            }
        }
        System.out.println(result.size());
        System.out.println(graph.size());
    }

}
