package com.strive.DP;


import java.util.Arrays;

//todo 动态规划求解
public class KnapsackProblem {
      /*
        0-1背包问题

         1.n个物品都是固体，有重量和价值
         2.现在你要取走 不超过10g 的物品
         3.每次可以不拿，全拿，或拿一部分，问最高价值是多少

             编号     重量(g)     价值(元)                      简称
              0         4        1600         黄金一枚          A
              1         8        2400       红宝石戒指一枚       R
              2         5        30           白银一枚          S
              3         1      1_000_000      钻石一枚          D
         1_001_630  贪心解
         1_002_400  正确解
       */

       /*
               0   1   2   3   4   5   6   7   8   9   10
          0    0   0   0   0   A   A   A   A   A   A   A      黄金
          1    0   0   0   0   A   A   A   A   R   R   R      红宝石
          2    0   0   0   0   A   A   A   A   R   R   R      白银
          3    0   D   D   D   D   DA  DA  DA  DA  DR  DR     钻石


       */

    static class Item {
        int index;
        String name;
        int weight;
        int value;

        public Item(){}

        public Item(int index,int value){
            this.index = index;
            this.value = value;
        }

        public Item(int index,int weight,int value){
            this.index = index;
            this.weight = weight;
            this.value = value;
        }

        public Item(int index, String name, int weight, int value) {
            this.index = index;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "index=" + index +
                    ", name='" + name + '\'' +
                    ", weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }

    //todo 二维数组
    static int select(Item[] items, int total) {
        int[][] dp = new int[items.length][total + 1];
        Item item0 = items[0];
        for (int j = 0; j < total + 1; j++) {
            if (j >= item0.weight) {
                dp[0][j] = item0.weight;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < total + 1; j++) {
                Item item = items[i];
                if (j >= item.weight) {
                    dp[i][j] = Integer.max(dp[i - 1][j], item.value + dp[i - 1][j - item.weight]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][total];
    }

    //todo 一维数组
    static int selectDown(Item[] items, int total) {
        int[] dp = new int[total + 1];
        Item item0 = items[0];
        for (int j = 0; j < total + 1; j++) {
            if (j >= item0.weight) {
                dp[j] = item0.value;
            } else {
                dp[j] = 0;
            }
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < items.length; i++) {
            Item item = items[i];
            for (int j = total; j > 0; j--) {
                if (j >= item.weight) {
                    dp[j] = Integer.max(dp[j], item.value + dp[j - item.weight]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[total];
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1, "黄金", 4, 1600),
                new Item(2, "宝石", 8, 2400),
                new Item(3, "白银", 5, 30),
                new Item(4, "钻石", 1, 1_000_000)
        };
        //System.out.println(select(items, 10));
        System.out.println(selectDown(items,10));
    }
}
