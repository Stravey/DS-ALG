package com.strive.Sort;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(bs.search(nums, 9));
    }

}
