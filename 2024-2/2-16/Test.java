package Test216;

import java.io.*;
import java.util.IllegalFormatCodePointException;
import java.util.WeakHashMap;

public class mergeSort {
    // 最大数据个数
    public static int MAXN = 501;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    // 输入数据个数
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0;i < n;i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            // 递归实现
            // mergeSort1(0,n - 1);
            mergeSort2();
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    // 递归实现
    public static void mergeSort1(int l,int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort1(l,m);
        mergeSort1(m + 1,r);
        merge(l,m,r);
    }

    // 非递归实现
    public static void mergeSort2() {
        for (int l, m, r, step = 1;step < n ;step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) {
                    break;
                }
                r = Math.min(l + (step << 1) - 1,n-1);
                merge(l,m,r);
                l = r + 1;
            }
        }
    }

    public static void merge(int l,int m,int r) {
        int a = l;
        int b = m + 1;
        int i = l;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (int j = l;j <= r;j++) {
            arr[j] = help[j];
        }
    }

}
