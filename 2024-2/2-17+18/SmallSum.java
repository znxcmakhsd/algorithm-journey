package Test217;

import java.io.*;
import java.util.IllegalFormatCodePointException;

// 1. 计算数组小和

// https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469

/*
public class SmallSum {

    public static int n;

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

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
            out.print(smallSum(0,n-1));
        }
        out.flush();
        out.close();
    }
    public static int smallSum(int l,int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(l,m) + smallSum(m+1,r) + merge(l,m,r);
    }
    public static int merge(int l,int m,int r) {
        // 计算左跨右小和
        int ans = 0;
        int i = l;
        for (int j = m + 1,sum = 0;j <= r;j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }

        // 归并排序
        int a = l;
        int b = m + 1;
        i = l;
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
        return ans;
    }
}
*/

public class SmallSum {
    // 数据量
    public static int n;
    // 最大数据个数
    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)in.nval;
            for (int i = 0;i < n;i++) {
                in.nextToken();
                arr[i] = (int)in.nval;
            }
            out.print(smallSum(0,n-1));
        }
        out.flush();
        out.close();
    }

    public static long smallSum(int l,int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(l,m) + smallSum(m+1,r) + merge(l,m,r);
    }

    public static long merge(int l,int m,int r) {
        int i = l;
        long ans = 0;
        for (int j = m + 1,sum = 0;j <= r;j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }
        int a = l;
        int b = m + 1;
        i = l;
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
        return ans;
    }
}
