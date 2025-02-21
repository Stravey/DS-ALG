package com.strive.DP;

//todo 完全背包问题 动态规划
public class KnapsackProblemComplete {
    static class Item{
        int index;
        String name;
        int weight;
        int value;

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

    /*

             i  0   1   2   3   4   5   6
          j
          0     0   0   c   c   cc  cc  ccc
          1     0   0   c   s   cc  sc  ccc
          2     0   0   c   s   a   a   ac

     */

    private static int select(Item[] items,int total){
        int[][] dp = new int[items.length][total + 1];
        Item item0 = items[0];
        //todo 处理第一行的数据
        for (int j = 0; j < total + 1; j++) {
            if(j >= item0.weight) {
                dp[0][j] = dp[0][j - item0.weight] + item0.value;
            }
        }
        //todo 处理后面几行的内容
        for (int i = 1; i < items.length; i++) {
            for (int j = 0; j < total + 1; j++) {
                Item item = items[i];
                //todo x为上次的价值
                int x = dp[i - 1][j];
                if(j >= item.weight) {
                    dp[i][j] = Integer.max(x,dp[i][j - item.weight] + item.value);
                } else {
                    dp[i][j] = x;
                }
            }
        }
        return dp[items.length - 1][total];
    }

    private static int selectDown(Item[] items,int total){
        int[] dp = new int[total + 1];
        Item item0 = items[0];
        //todo 处理每行的内容
        for (Item value : items) {
            for (int j = 0; j < total + 1; j++) {
                Item item = value;
                //todo x为上次的价值
                if (j >= item.weight) {
                    dp[j] = Integer.max(dp[j], dp[j - item.weight] + item.value);
                }
            }
        }
        return dp[total];
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1,"青铜",2,3),    //c
                new Item(2,"白银",3,4),    //s
                new Item(3,"黄金",4,7)     //a
        };
        System.out.println(select(items,6));
        System.out.println(selectDown(items,6));
    }
}
