package Test217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Test217 {

    // 1. 递归找数组最大值
    class GetMaxValue {
        public static int getMaxValue(int[] arr) {
            return func(arr, 0, arr.length-1);
        }

        public static int func(int[] arr,int l,int r) {
            if (l == r) {
                return arr[l];
            }
            int m = (l + r) / 2;
            int lmax = func(arr,l,m);
            int rmax = func(arr,m+1,r);
            return Math.max(lmax,rmax);
        }
    }

    public static void main(String[] args) {
        /*int[] arr = {5,3,1,2,4};
        System.out.println(GetMaxValue.getMaxValue(arr));*/

    }


}
