package com.strive.Graph;

import java.util.List;
import java.util.Random;

public class Map {
    public static final int Length = 15;
    public static final int Weight = 20;
    private Node[][] map;
    private Node start;
    private Node end;

    public Map() {
        map = new Node[Length][Weight];
        Random random = new Random();
        int startX = random.nextInt(Length - 2) + 1;
        int startY = random.nextInt(Length - 2) + 1;
        int endX = random.nextInt(Length - 2) + 1;
        int endY = random.nextInt(Length - 2) + 1;
        System.out.println("起点坐标：" + startX + "," + startY);
        System.out.println("目标点坐标：" + endX + "," + endY);
        for(int i = 0;i < Length;i++) {
            for(int j = 0;j < Weight;j++) {
                Node node = new Node(i,j,"0",true);
                if(i == 0 || j == 0 || i == Length - 1 || j == Weight - 1) {
                    node.setValue("*");
                    node.setReachable(false);
                } else {
                    int num = random.nextInt(10);
                    if(num < 3) {
                        node.setValue("*");
                        node.setReachable(false);
                    }
                    if(i == startX && j == startY) {
                        node.setValue("A");
                        node.setReachable(true);
                        start = node;
                    }
                    if(i == endX && j == endY) {
                        node.setValue("B");
                        node.setReachable(true);
                        end = node;
                    }
                }
                map[i][j] = node;
            }
        }
    }

    public void ShowMap(List<Node> nodeList) {
        System.out.println("\\" + "  ");
        for(int i = 0;i < Weight;i++) {
            System.out.println(i + "   ");
        }
        System.out.println();
        for(int i = 0;i < Length;i++) {
            for(int j = 0;j < Weight;j++) {
                Node node = map[i][j];
                String value = map[i][j].getValue();
                if(nodeList == null) {
                    if("A".equals(value) || "B".equals(value)) {
                        System.out.format("\33[41;4m" + value + "\33[0m" + "  ");
                    } else {
                        if(j == 0){
                            System.out.print(i + "  ");
                            System.out.print(value + "  ");
                        } else {
                            System.out.print(value + "  ");
                        }
                    }
                } else {
                    if(j == 0){
                        System.out.println(i + "  ");
                    }
                    if(nodeList.contains(node)) {
                        System.out.format("\33[41;4m" + value + "\33[0m" + "  ");
                    } else {
                        System.out.println(value + "  ");
                    }
                }
            }
            System.out.println();
        }
    }
}
