// 1. 计算对
public class ReversePairs {

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    public int reversePairs(int[] arr) {
        return count(arr,0,arr.length-1);
    }

    public static int count(int[] arr,int l,int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return count(arr,l,m) + count(arr,m+1,r) + merge(arr,l,m,r);
    }

    public static int merge(int[] arr,int l,int m,int r) {
        int ans = 0;
        for (int i = l,j = m + 1,sum = 0;i <= m;i++) {
            while (j <= r && arr[i] > (long) arr[j] * 2) {
                sum++;
                j++;
            }
            ans += sum;
        }
        // 归并排序
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
        for (i = l;i <= r;i++) {
            arr[i] = help[i];
        }
        return ans;
    }
}

————————————————————————

// 2. 数组小和

import java.io.*;

public class smallSum {

    public static int n;

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static void main(String[] args) throws IOException{
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

    public static long smallSum(int l,int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(l,m) + smallSum(m+1,r) + merge(l,m,r);
    }

    public static long merge(int l,int m,int r) {
        long ans = 0;
        for (int i = l,j = m + 1,sum = 0;j <= r;j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }
        // 归并排序
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
        for (i = l;i <= r;i++) {
            arr[i] = help[i];
        }
        return ans;
    }

}
