public class HeapSort {

    // 向上调整大根堆
    public static void heapInsert(int[] arr, int child) {
        int parent = (child - 1) / 2;
        while (arr[child] > arr[parent]) {
            swap(arr,child,parent);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    // 向下调整大根堆
    public static void heapify1(int[] arr, int parent, int size) {
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
                swap(arr,child,parent);
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }

    public static void heapify2(int[] arr, int p, int size) {
        int c = p * 2 + 1;
        while (c < size) {
            // 有左孩子
            // 选左右最大孩子
            int best = c + 1 < size && arr[c + 1] > arr[c] ? c + 1: c;
            best = arr[best] > arr[p] ? best : p;
            if (best == p) {
                break;
            }
            swap(arr,best,p);
            p = best;
            c = p * 2 + 1;
        }
    }


    public static void createBigHeap(int[] arr) {
        // 向上调整建堆
        /*
        for (int i = 0;i < arr.length;i++) {
            heapInsert(arr,i);
        } */

        // 向下调整建堆
        int parent = (arr.length - 1 - 1) / 2;
        for (int i = parent;i >= 0;i--) {
            heapify2(arr,i,arr.length);
        }
    }

    public static void swap(int[] arr,int x,int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void heapSort(int[] arr) {
        createBigHeap(arr);
        int n = arr.length;
        while (n > 1) {
            swap(arr,0,--n);
            heapify1(arr,0,n);
        }
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            heapSort(nums);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,2,7};
        sortArray(arr);
    }
}
