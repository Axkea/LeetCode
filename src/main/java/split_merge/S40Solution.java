package split_merge;

import java.util.PriorityQueue;

public class S40Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int n=arr.length;
        int[] res=new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(n + 1,(a,b)->a-b);
        for (int i = 0; i < n; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            res[i]=priorityQueue.poll();
        }
        return res;
    }
}
