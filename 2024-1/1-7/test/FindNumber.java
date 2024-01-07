package test;

// 在一个有序数组中找是否存在 n

import java.util.Arrays;

public class FindNumber {
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 500000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            //  Math.random() 生成 [0,1) 之间小数
            // (Math.random() * N) 生成 [0,N) 之间小数
            // (int) (Math.random() * N) 生成 [0,N-1] 之间整数
            int n = (int) (Math.random() * N);
            int[] arr = randomArray(n, V);
            Arrays.sort(arr);
            int num = (int) (Math.random() * V);
            if (right(arr, num) != exist(arr, num)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    // 为了验证
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // [1,v] 之间整数
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    // 为了验证
    // 保证arr有序，才能用这个方法
    public static boolean right(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0,right = arr.length-1,mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == num) {
                return true;
            }else if (arr[mid] < num) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

}
