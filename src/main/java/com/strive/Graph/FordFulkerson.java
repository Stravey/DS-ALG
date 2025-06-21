package com.strive.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图采用邻接矩阵表示 通过BFS来实现算法
 */
@SuppressWarnings("all")
public class FordFulkerson {

    private int numVertices;
    private int[][] residualGraph;

    /**
     * 构造函数
     * @param numVertices
     */
    public FordFulkerson(int numVertices) {
        this.numVertices = numVertices;
        this.residualGraph = new int[numVertices][numVertices];
    }

    /**
     * 向图中添加边
     * @param source
     * @param destination
     * @param capacity
     */
    public void addEgde(int source,int destination,int capacity) {
        residualGraph[source][destination] = capacity;
    }

    /**
     * 计算最大网络流
     * @param source
     * @param sink
     * @return
     */
    public int maxFLow(int source,int sink) {
        int maxFlow = 0;
        // 用于存储增广路径
        int[] parent = new int[numVertices];

        while(bfs(source,sink,parent)) {
            int parentFlow = Integer.MAX_VALUE;
            for(int v = sink;v != source;v = parent[v]) {
                int u = parent[v];
                parentFlow = Math.min(parentFlow,residualGraph[u][v]);
            }

            for(int v = sink;v != source;v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= parentFlow;

                residualGraph[v][u] += parentFlow;
            }

            maxFlow += parentFlow;
        }

        return maxFlow;
    }

    /**
     * BFS算法
     * @param source
     * @param sink
     * @param parent
     * @return
     */
    public boolean bfs(int source,int sink,int[] parent) {
        boolean visited[] = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int v = 0; v < numVertices; v++) {
                if(!visited[v] && residualGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        // 如果汇点被访问到 说明存在增广路径
        return visited[sink];
    }


    public static void main(String[] args) {
        int numVertices = 6;
        FordFulkerson ff = new FordFulkerson(numVertices);

        ff.addEgde(0,1,16);
        ff.addEgde(0,2,13);
        ff.addEgde(1,2,10);
        ff.addEgde(1,3,12);
        ff.addEgde(2,1,4);
        ff.addEgde(3,2,9);
        ff.addEgde(3,5,20);
        ff.addEgde(4,3,7);
        ff.addEgde(4,5,4);

        int source = 0;
        int sink = 5;

        int maxFlow = ff.maxFLow(source,sink);
        System.out.println("最大网络流:" + maxFlow);

    }

}
