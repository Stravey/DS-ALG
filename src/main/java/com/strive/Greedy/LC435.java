package com.strive.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//todo 无重叠区间本质就是活动选择问题
public class LC435 {
    //todo 贪心策略1.优先选择持续时间最少的活动  ×
    //todo 贪心策略2.优先选择冲突次数最少的活动  ×
    //todo 贪心策略3.优先选择最先开始的活动  ×
    //todo 贪心策略4.优先选择最先结束的活动  √
    static class Acitivity{
        int index;
        int start;
        int finish;
        public Acitivity(int index,int start,int finish){
            this.index = index;
            this.start = start;
            this.finish = finish;
        }

        public int getFinish() {
            return finish;
        }

        @Override
        public String toString() {
            return "Acitivity(" + index + ")";
        }
    }

    public static void main(String[] args) {
        Acitivity[] acitivities = new Acitivity[]{
                new Acitivity(0,1,3),
                new Acitivity(1,2,4),
                new Acitivity(2,3,5)
        };
        Arrays.sort(acitivities, Comparator.comparingInt(Acitivity::getFinish));
        System.out.println(Arrays.toString(acitivities));
        select(acitivities,acitivities.length);
    }

    public static void select(Acitivity[] acitivities,int n) {
        List<Acitivity> result = new ArrayList<>();
        Acitivity prev = acitivities[0]; //上次被选中的活动
        result.add(prev);
        for (int i = 1; i < n; i++) {
            Acitivity cur = acitivities[i]; //正在处理的活动
            if(cur.start >= prev.finish) {
                result.add(cur);
                prev = cur;
            }
        }
        for (Acitivity acitivity : result) {
            System.out.println(acitivity);
        }
    }
}
