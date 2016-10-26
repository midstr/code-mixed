package org;

import java.util.Arrays;

/**
 * Created by liyaogang on 2016/10/26.
 */
public class Algorithm {


    /**
     * Created by liyaogang on 2016/10/26.
     */
    public static void main(String[] args) {
        Algorithm testOOM = new Algorithm();
        int[] ary = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int max = testOOM.maxSubArray(ary);
        System.out.println(max);

        int[] sorted = testOOM.sort(ary);
        System.out.println(Arrays.toString(sorted));

        System.out.println(testOOM.search1(sorted, 6));

        System.out.println(testOOM.search2(sorted, 6));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }


    public int search1(int[] nums, int value) {
        int start = 0, end = nums.length - 1;
        return search(nums, value, start, end);
    }

    private int search(int[] nums, int value, int start, int end) {
        if (start > end) {
            return -1;
        }
        int index = (start + end) / 2;
        if (nums[index] == value) {
            return index;
        } else if (nums[index] < value) {
            return search(nums, value, index + 1, end);
        } else {
            return search(nums, value, start, index - 1);
        }
    }

    public int search2(int[] nums, int value) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == value) {
                return mid;
            } else if (nums[mid] < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
