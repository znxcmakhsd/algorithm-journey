package Test217;

import java.awt.event.MouseAdapter;
import java.io.*;

public class ReversePairs {

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    public static long reversePairs(int[] arr) {
        return count(arr,0,arr.length-1);
    }

    public static long count(int[] arr,int l,int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return count(arr,l,m) + count(arr,m+1,r) + merge(arr,l,m,r);
    }

    public static long merge(int[] arr,int l,int m,int r) {
        long ans = 0;
        for (int i = l,sum = 0,j = m+1;i <= m;i++) {
            while (j <= r && arr[i] > 2 * arr[j]) {
                sum++;
                j++;
            }
            ans += sum;
        }

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

    public static void main(String[] args) {
        int arr[] = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(arr));
    }
}
