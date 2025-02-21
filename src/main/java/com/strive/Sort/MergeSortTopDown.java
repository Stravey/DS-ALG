package com.strive.Sort;

import java.util.Arrays;

//todo 归并排序 非递归方法
public class MergeSortTopDown {
    public static void merge(int[] a1,int i,int iEnd,int j,int jEnd,int[] a2){
        int k =i;
        while(i <= iEnd && j <= jEnd){
            if(a1[i] < a1[j]){
                a2[k] = a1[i];
                i++;
            }else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if(i > iEnd){
            System.arraycopy(a1,j,a2,k,jEnd - j + 1);
        }
        if(j > jEnd){
            System.arraycopy(a1,i,a2,k,iEnd - i + 1);
        }
    }

    public static void sort(int[] a1){
        int n = a1.length;
        int[] a2 = new int[n];
        //todo width 代表有序区间的宽度,取值依次为 1，2，3，4 ......
        for (int width = 1; width < n; width *= 2) {
            //todo [left,right] 分别代表待合并区间的左右边界
            for (int left = 0;left < n;left += 2 * width){
                int right = Math.min(left + 2 * width - 1,n - 1);
                //System.out.printf("width %d [%d,%d]%n",width,left,right);
                int m = Math.min(left + width - 1,n - 1);
                merge(a1,left,m,m + 1,right,a2);
            }
            System.arraycopy(a2,0,a1,0,n);
        }
    }

    public static void main(String[] args) {
        int[] a = {7,3,6,2,9,4,1,0};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
