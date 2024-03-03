
3 - 3

1. top-k 问题
https://leetcode.cn/problems/smallest-k-lcci/description/

/*
class Cmp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
 
class Solution {
 
     public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k,new Cmp());
 
        for (int i = 0;i < k;i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k;i < arr.length;i++) {
            int top = priorityQueue.peek();
            if (arr[i] < top) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        
        int[] ret = new int[k];
        for (int i = 0;i < k;i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
 
    }
}
*/