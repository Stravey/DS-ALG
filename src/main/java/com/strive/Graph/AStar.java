package com.strive.Graph;

import java.util.*;

@SuppressWarnings("all")
public class AStar {

    /**
     *  A*结点类
     */
    private static class ANode {
        int x,y;
        int f,g,h;
        ANode parent;

        public ANode(int x,int y) {
            this.x = x;
            this.y = y;
        }

        // 计算启发式函数值 （曼哈顿距离）
        public void calculateHeuristic(ANode endNode) {
            this.h = Math.abs(endNode.x - x) + Math.abs(endNode.y - y);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            ANode node = (ANode) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, f, g, h, parent);
        }
    }

    /**
     * A*算法实现
     * @param grid 图
     * @param start 开始点
     * @param end 结束点
     * @return 一条路径
     */
    public static List<ANode> findPath(int[][] grid, ANode start, ANode end) {
        // 定义可移动方向
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        // 初始化开放列表和关闭列表
        PriorityQueue<ANode> openlist = new PriorityQueue<>(Comparator.comparingInt(node -> node.f));
        Set<ANode> closedList = new HashSet<>();

        // 初始化起点
        start.g = 0;
        start.calculateHeuristic(end);
        start.f = start.g + start.h;
        openlist.add(start);

        while(!openlist.isEmpty()){
            // 获取F值最小的节点
            ANode current = openlist.poll();
            // 如果到达终点 回溯路径
            if(current.equals(end)) {
                return reconstructPath(current);
            }
            closedList.add(current);
            // 遍历所有点
            for(int[] direction : directions){
                // x方向
                int x = current.x + direction[0];
                // y方向
                int y = current.y + direction[1];
                // 是否在网格范围
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
                    continue;
                }
                // 是否是障碍物
                if(grid[x][y] == 1){
                    continue;
                }
                ANode neighbor = new ANode(x, y);
                // 如果找到在关闭列表中
                if(closedList.contains(neighbor)){
                    continue;
                }
                // 计算新的G值
                int tentativeG = current.g + 1;

                // 如果不在开放列表中 或找到更优路径
                if(!openlist.contains(neighbor) || tentativeG < neighbor.g){
                    neighbor.parent = current;
                    neighbor.g = tentativeG;
                    neighbor.calculateHeuristic(end);
                    neighbor.f = neighbor.g + neighbor.h;
                    if(!openlist.contains(neighbor)){
                        openlist.add(neighbor);
                    }

                }
            }
        }
        // 没有找到路径
        return Collections.emptyList();
    }

    /**
     * 终点回溯路径
     * @param endNode 结束点
     * @return 路径
     */
    private static List<ANode> reconstructPath(ANode endNode) {
        List<ANode> path = new ArrayList<>();
        ANode cur = endNode;
        while(cur != null){
            path.add(cur);
            cur = cur.parent;
        }
        Collections.reverse(path);
        return path;
    }


    public static void main(String[] args) {
        // 1 障碍物  0 表示通过
        int[][] grid = {
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        ANode start = new ANode(0,0);
        ANode end = new ANode(9,9);

        List<ANode> path = findPath(grid, start, end);

        if(path.isEmpty()){
            System.out.println("Path is empty");
        } else {
            System.out.println("Path found:");
            for(ANode node : path){
                System.out.printf(node.x + " " + node.y);
            }
        }
    }

}
