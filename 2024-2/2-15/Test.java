package Test214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

// acm练习风格:
public class MergeSort1 {

    // 最大数组长度
    public static int MAXN = 501;

    public static int[] arr = new int[MAXN];
    public static int[] help = new int[MAXN];

    // 数组数据个数
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            // 把数据搞进数组
            n = (int) in.nval;
            for (int i = 0;i < n;i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            // 开始排序
            mergeSort1(0,n - 1); // 递归实现

            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    public static void mergeSort1(int l,int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort1(l,m);
        mergeSort1(m+1,r);
        merge(l,m,r);
    }

    public static void merge(int l,int m,int r) {
        int a = l;
        int b = m+1;
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
        for (i = l;i <= r;i++) {
            arr[i] = help[i];
        }
    }

}
