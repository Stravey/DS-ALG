package com.strive.Graph;

import java.util.List;
import java.util.Objects;

//todo 顶点类
public class Vertex {
    String name; //todo 顶点的名字
    List<Edge> edges; //todo 边的List集合
    boolean visited; //todo 访问过的结点
    int inDegree; //todo 入度
    int status; //todo 初始 0-为访问 1-访问中 2-访问过
    int dist = INF; //todo 距离
    static final Integer INF = Integer.MAX_VALUE;
    Vertex prev = null; //todo 记录前一个

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
        Vertex vertex = (Vertex) object;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
