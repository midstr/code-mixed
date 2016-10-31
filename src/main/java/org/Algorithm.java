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

        testOOM.quickSort(ary);
        System.out.println(Arrays.toString(ary));

        int[] sorted = testOOM.sort(ary);
        System.out.println(Arrays.toString(sorted));

        System.out.println(testOOM.search1(sorted, 6));

        System.out.println(testOOM.search2(sorted, 6));


        // n = 5, m = 3
        // a[N]到a[N+M-1]
        print();

        p2();

        reverseWords();
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

    public void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
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

    public static void print() {
        int[] ary = {5, 5, 3, 4, 4, 1, 2, 5};;
        for (int i = 0; i < ary.length; i++) {
            int first = ary[i];
            int second = ary[first - 1];
            if (first != second) {
                swap(ary, i, first -1 );
            }
        }
        System.out.println("print:");
        System.out.println(Arrays.toString(ary));
    }

    public static void p2 () {
        {
            int[] A = new int[] { 1, 3, 4, 8, 7, 5, 6,  10, 11, 12 };
            int n = A.length + 2;
            int sum = (n * (n + 1)) >> 1;
            int squareSum = sum * (2 * n + 1) / 3;

            for (int i = 0; i < A.length; i++)
            {
                sum -= A[i];
                squareSum -= A[i] * A[i];
            }

            int k = (int)Math.sqrt((squareSum << 1) - sum * sum);
            System.out.printf("%d,%d", (sum + k) >> 1, (sum - k) >> 1);
        }

    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static String reverseWords() {
        System.out.println();
        String s = "hello world!";
        s= "1 ";
        if (s == null || s.trim().equals("")) {
            return s;
        }

        s = s.replaceAll(" +", " ").trim();
        System.out.println(s);
        char[] chars = s.toCharArray();
        reverseWord(chars, 0, chars.length-1);

        int start =0,end;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                end = i-1;
                reverseWord(chars, start, end);
                start = i+1;
            } else if (i == chars.length-1) {
                end = i;
                reverseWord(chars, start, end);
                start = i+1;
            }

        }
        new String(chars);
        System.out.println(Arrays.toString(chars));
        return null;
    }

    private static void reverseWord(char[] chars, int start, int end) {
        System.out.println(Arrays.toString(chars) + " " + start + "," + end);

        // abcdef
        for (int i = start; i <= (start+ end) / 2; i ++) {
            //System.out.println("swap:" + i + ":" +(start + end -i));
            char temp = chars[i];
            chars[i] = chars[start + end -i];
            chars[start + end -i] = temp;
        }
        System.out.println(Arrays.toString(chars));
    }

}
