import java.util.Arrays;


public class FindNumber {

    // 在一个有序数组中找是否存在num
    public static boolean exist(int[] arr,int num) {
        int l = 0, r = arr.length-1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] == num) {
                return true;
            } else if (num < arr[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    // --------- 用对数器检查是否正确 ---------
    public static boolean right(int[] arr, int num) {
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    // 生成随机数组
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0;i < n;i++) {
            // (int)Math.random() ——》 [0,1)
            // (int)(Math.random() * v) ——》 0 1 2 ... v-1
            // (int)(Math.random() * v) + 1 ——》 1 2 3 ... v
            arr[i] = (int)(Math.random() * v) + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 50000;
        System.out.println("测试开始");
        for (int i = 0;i < testTime;i++) {

            int n = (int)(Math.random() * N); // 生成 0 ~ N-1 之间的随机数
            int[] arr = randomArray(n,V); // 生成 数组长度: 0 ~ N-1 ,数据大小 1 ~ V
            Arrays.sort(arr);
            int num = (int) (Math.random() * V) + 1;

            if (right(arr, num) != exist(arr, num)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }
}

/*
public class Test204 {

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    // 1. 选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0,minIndex;i < arr.length-1;i++) {
            minIndex = i;
            for (int j = i+1;j < arr.length;j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    // 2. 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length-1;end > 0;end--) {
            for (int i = 0;i < end;i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr,i,i+1);
                }
            }
        }
    }

    // 3. 插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1;i < arr.length;i++) {
            for (int j = i-1;j >= 0;j--) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }

    // 得到随机数组
    public static int[] randomArray(int n,int v) {
        int[] arr = new int[n];
        for (int i = 0;i < n;i++) {
            // (int)Math.random() ---> [0,1)
            // (int)Math.random() * v ---> 0 1 2 ... v-1
            // (int) (Math.random() * v) + 1; --->  0 1 2 ... v
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }
    // 为了验证
    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // 为了验证
    public static boolean sameArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        //selectionSort(arr);
        //bubbleSort(arr);
        //insertionSort(arr);
    }
}
*/
