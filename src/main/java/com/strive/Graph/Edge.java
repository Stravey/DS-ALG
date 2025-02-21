package com.strive.Graph;

//todo 边类
public class Edge {
    Vertex linked; //todo 相邻的点
    int weight; //todo 权重 即值

    public Edge(Vertex linked){
        this(linked,1);
    }

    public Edge(Vertex linked,int weight){
        this.linked = linked;
        this.weight = weight;
    }
}
