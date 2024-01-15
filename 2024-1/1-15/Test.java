package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


//  https://www.nowcoder.com/practice/bc25055fb97e4a0bb564cb4b214ffa92

public class Test {

    public static int MAXN = 501;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static int n;

    public static void mergeSort1(int l,int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort1(l,m);
        mergeSort1(m+1,r);
        merge(l,m,r);
    }

    /*public static void mergeSort2() {
        // 一共发生O(logn)次
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            // 内部分组merge，时间复杂度O(n)
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) {
                    break;
                }
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }*/

    public static void merge(int l,int m,int r) {
        int a = l;
        int i = l;
        int b = m + 1;

        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        // 一定是一个走完 一个没走完
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

    public static void main(String[] args) throws IOException {

        // 把网址后台的测试数据导入进来 保存进内存
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 一个一个读数据
        StreamTokenizer in = new StreamTokenizer(br);
        // 提交答案的时候用的，也是一个内存托管区
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            // n 表示数组数据个数
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }

            //mergeSort1(0,n-1);
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
}
