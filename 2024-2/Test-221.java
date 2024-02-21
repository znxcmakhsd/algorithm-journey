
// 1. acm 风格
package Test220;

import java.io.*;


public class QuickSort1 {

    public static int MAXN = 1001;

    public static int[] arr = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            // quickSort1(0, n - 1);
            quicksort2(0,n-1);
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    public static int first,last;

    public static void quicksort2(int l,int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        partition2(l,r,x);
        int left = first;
        int right = last;
        quicksort2(l,left - 1);
        quicksort2(right + 1,r);
    }

    public static void partition2(int l,int r,int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                swap(first++,i++);
            } else {
                swap(i,last--);
            }
        }
    }


    public static void quickSort1(int l,int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        int m = partition1(l,r,x);
        quickSort1(l,m-1);
        quickSort1(m+1,r);
    }

    // <= x | x <
    public static int partition1(int l,int r,int x) {
        int a = l,xi = -1;
        for (int i = l;i <= r;i++) {
            if (arr[i] <= x) {
                swap(a,i);
                if (arr[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        swap(xi,a-1);
        return a - 1;
    }

    public static void swap(int x,int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

   /* public static void quickSort1(int l,int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        int m = partition1(l,r,x);
        quickSort1(l,m-1);
        quickSort1(m+1,r);
    }

    public static int partition1(int l,int r,int x) {
        int a = 0,xi = 0;
        for (int i = 0;i <= r;i++) {
            if (arr[i] <= x) {
                swap(a,i);
                if (arr[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        swap(xi,a-1);
        return a - 1;
    }

    public static void swap(int x,int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }*/


    /*public static void quickSort1(int l,int r) {
        if (l >= r) {
            return;
        }
        // 等概率得到 [l....r]之间的随机值
        int x = arr[l + (int)Math.random() * (r - l + 1)];
        int m = partition1(l,r,x);
        quickSort1(l,m-1);
        quickSort1(m+1,r);
    }

    public static int partition1(int l,int r,int x) {
        // <= x | x | x <
        int xi = -1, a = l;
        for (int i = l;i <= r;i++) {
            if (arr[i] <= x) {
                swap(a,i);
                if (arr[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        swap(xi,a-1);
        return a - 1;
    }
    public static void swap(int x,int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }*/


}


// 2. 填函数风格
package Test220;

// 优化版本
// https://leetcode.cn/problems/sort-an-array/

/*
public class QuickSort2 {

    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            quickSort2(nums,0,nums.length - 1);
        }
        return nums;
    }

    public static void quickSort2(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        partition2(arr,l,r,x);
        int left = first;
        int right = last;
        quickSort2(arr,l,left - 1);
        quickSort2(arr,right + 1,r);
    }

    public static int first,last;

    public static void partition2(int[] arr,int l,int r,int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] > x) {
                swap(arr,i,last--);
            }else if(arr[i] < x) {
                swap(arr,i++,first++);
            }else {
                i++;
            }
        }
    }

    public static void swap(int[] arr,int x,int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
*/


