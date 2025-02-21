package com.strive.Greedy;

import java.util.Arrays;
import java.util.Comparator;

//todo 分数背包问题
public class FractionalKnapsackProblem {
    /*
    1.n个物品都是液体，有重量和价值
    2.现在你要取走 10升 的液体
    3.每次可以不拿，全拿，或拿一部分，问最高价值是多少

    编号     重量(升)     价值
    0         4         24        水
    1         8         160       牛奶
    2         2         4000      五粮液
    3         6         108       可乐
    4         1         4000      茅台

    简化起见，给出的数据都是可以整除的
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

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(0,4,24),
                new Item(1,8,160),
                new Item(2,2,4000),
                new Item(3,6,108),
                new Item(4,1,4000)
        };
        select(items,10);
    }
    static void select(Item[] items,int total) {
        Arrays.sort(items, Comparator.comparingDouble(Item::unitValue).reversed());
        int max = 0;
        for(Item item : items) {
            System.out.println(item);
            if(total >= item.weight) {
                total -= item.weight;
                max += item.value;
            } else {
                max += (int) (total * item.unitValue());
                break;
            }
        }
        System.out.println(max);
    }
}
