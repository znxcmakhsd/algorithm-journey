package demo1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        for (int i = 0;i < arr.length-1;i++) {
            int minIndex = i;
            for (int j = i + 1;j < arr.length;j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }
    }
    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        /*for (int i = 0;i < arr.length-1;i++) {
            for (int j = 0;j < arr.length-1-i;j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }*/
        for (int end = arr.length-1;end > 0;end--) {
            for (int j = 0;j < end;j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void insertionSort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        for (int i = 1;i < arr.length;i++) {
            for (int j = i-1;j >= 0 && arr[j] > arr[j+1];j--) {
                swap(arr,j,j+1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,3,1,2,4};
        //selectionSort(arr);
        //bubbleSort(arr);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
