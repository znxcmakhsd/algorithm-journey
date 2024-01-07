package test;


public class FindPeakElement {

    // 测试链接 : https://leetcode.cn/problems/find-peak-element/
    class Solution {

        public static int findPeakElement(int[] arr) {
            // 如果数组长度为1 那么0小下标就是峰值 因为 左右是无穷小
            if (arr.length == 1) {
                return 0;
            }
            // 数组长度 >= 2
            int n = arr.length;
            if (arr[0] > arr[1]) {
                return 0;
            }
            if (arr[n-1] > arr[n-2]) {
                return n-1;
            }
            int left = 1,right = arr.length-2,mid = 0;
            int ans = -1;
            while (left <= right) {
                mid = (left+right)/2;
                if (arr[mid-1] > arr[mid]) { 
                    right = mid - 1;
                }else if (arr[mid+1] > arr[mid]) {
                    left = mid + 1;
                }else {
                    ans = mid;
                    break;
                }
            }
            return ans;
        }

    }

}