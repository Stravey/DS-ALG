package com.strive.Greedy;

import java.util.Arrays;
import java.util.Comparator;

//todo 使用贪心算法不一定达到最优解
//todo 贪心算法求解
public class KnapsackProblem {
     /*
     0-1背包问题

         1.n个物品都是固体，有重量和价值
         2.现在你要取走 不超过10g 的物品
         3.每次可以不拿，全拿，或拿一部分，问最高价值是多少

             编号     重量(g)     价值(元)
              0         1      1_000_000      钻戒一枚         选中
              1         4        1600         黄金一枚         选中
              2         8        2400         红宝石戒指一枚
              3         5         30          白银一枚         选中
         1_001_630
     */
     static class Item{
         int index;
         int weight;
         int value;

         public Item(int index, int weight, int value) {
             this.index = index;
             this.weight = weight;
             this.value = value;
         }

         public double unitValue(){
             return (double) value / weight;
         }

         @Override
         public String toString() {
             return "Item(" + index +")";

         }
     }

    static void select(Item[] items, int total) {
        Arrays.sort(items, Comparator.comparingDouble(Item::unitValue).reversed());
        int max = 0;
        for(Item item : items) {
            System.out.println(item);
            if(total >= item.weight) {
                total -= item.weight;
                max += item.value;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(0,1,1000000),
                new Item(1,4,1600),
                new Item(2,8,2400),
                new Item(3,5,30),
        };
        select(items,10);
    }
}
