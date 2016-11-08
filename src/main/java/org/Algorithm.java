package org;

import java.util.*;

/**
 * Created by liyaogang on 2016/10/26.
 */
public class Algorithm {


    /**
     * Created by liyaogang on 2016/10/26.
     */
    public static void main(String[] args) {
//        Algorithm testOOM = new Algorithm();
//        int[] ary = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//
//        int max = testOOM.maxSubArray(ary);
//        System.out.println(max);
//
//        testOOM.quickSort(ary);
//        System.out.println(Arrays.toString(ary));
//
//        int[] sorted = testOOM.sort(ary);
//        System.out.println(Arrays.toString(sorted));
//
//        System.out.println(testOOM.search1(sorted, 6));
//
//        System.out.println(testOOM.search2(sorted, 6));
//
//
//        // n = 5, m = 3
//        // a[N]到a[N+M-1]
//        print();
//
//        p2();
//
//        reverseWords();

//        System.out.println(int2Comma(1000));

//        int ret = (int) Math.ceil(1 / 0.75f) + 1;
//        System.out.println(ret);


//        String [] data = {"1","2","3","4"};
//        List listData = Arrays.asList(data);
//        listAll(listData, "");

//        Combination();
//        combination1();

        String s = "abc";
        String result = "";
        permutation1(s, result, s.length());
    }

    public static String int2Comma(int data) {
        String rest = "";
        if (data < 1000) {
            return String.valueOf(data);
        }
        for (;;) {
            int mod = data % 1000;
            data = data / 1000;
            if (data < 1000) {
                rest = data + "," + String.valueOf(mod + 1000).substring(1) + rest;
                break;
            } else {
                rest = "," +String.valueOf(mod + 1000).substring(1) + rest;
            }

        }
        return rest;
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Set finded = new HashSet();
        LinkedHashMap unique = new LinkedHashMap();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (finded.contains(c)) {
                unique.remove(c);
                continue;
            } else {
                finded.add(c);
                unique.put(c, i);
            }
        }
        if (unique.size() > 0) {
            return (Integer)unique.values().iterator().next();
        }
        return -1;
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

    public static void listAll(List data,String prefix) {
        System.out.println(prefix);
        for (int i = 0; i < data.size(); i++) {
            List temp = new LinkedList(data);
            String tempString = prefix + temp.remove(i);
            listAll(temp, tempString);
        }

    }


    public static  void Combination( ) {
        /*基本思路：求全组合，则假设原有元素n个，则最终组合结果是2^n个。原因是：
         * 用位操作方法：假设元素原本有：a,b,c三个，则1表示取该元素，0表示不取。故去a则是001，取ab则是011.
         * 所以一共三位，每个位上有两个选择0,1.所以是2^n个结果。
         * 这些结果的位图值都是0,1,2....2^n。所以可以类似全真表一样，从值0到值2^n依次输出结果：即：
         * 000,001,010,011,100,101,110,111 。对应输出组合结果为：
        空,a, b ,ab,c,ac,bc,abc.
        这个输出顺序刚好跟数字0~2^n结果递增顺序一样
        取法的二进制数其实就是从0到2^n-1的十进制数
         * ******************************************************************
         * *
         * */
        String[] str = {"a" , "b" ,"c"};
        int n = str.length;                                  //元素个数。
        //求出位图全组合的结果个数：2^n
        int nbit = 1<<n;                                     // “<<” 表示 左移:各二进位全部左移若干位，高位丢弃，低位补0。:即求出2^n=2Bit。
        System.out.println("num::"+nbit);

        for(int i=0 ;i<nbit ; i++) {                        //结果有nbit个。输出结果从数字小到大输出：即输出0,1,2,3,....2^n。
            System.out.print("the "+i + " code is :");
            for(int j=0; j<n ; j++) {                        //每个数二进制最多可以左移n次，即遍历完所有可能的变化新二进制数值了
                int tmp = 1<<j ;
                if((tmp & i)!=0) {                            //& 表示与。两个位都为1时，结果才为1
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }

    public static void combination1() {
            /*全组合：
             * 思路是利用二进制的特性，每次加1即可遍历所有位的不同情况，很好理解
            代码同上
                */
        String arr[] = {"a", "b", "c"};
        int all = arr.length;
        int nbit = 1 << all;
        for (int i = 0; i < nbit; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < all; j++) {
                if ((i & (1 << j)) != 0) {
                    sb.append(arr[j]);
                }
            }
            System.out.println(sb);
        }
    }


    public static void permutation1(String str ,String result ,int len){
        /* 全排列 递归实现
      递归树：
          str:          a            b                c
                      ab ac         ba   bc         ca   cb
        result:        abc acb        bac    bca      cab   cba
         */

        //结果 开始传入""   空字符进入   len   是这个数的长度
        if(result.length()==len){            //表示遍历完了一个全排列结果
            System.out.println(result);
        }
        else{
            for(int i=0;i<str.length();i++){
                if(result.indexOf(str.charAt(i))<0){    //返回指定字符在此字符串中第一次出现处的索引。
                    //System.out.println("字母："+str.charAt(i));
                    permutation1(str, result+str.charAt(i), len);
                }
            }
        }
    }
}
