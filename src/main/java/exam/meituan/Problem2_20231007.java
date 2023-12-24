package exam.meituan;

import java.util.PriorityQueue;

public class Problem2_20231007 {
    //小美计划派遣一位勇敢的冒险家前往解开宝塔的秘密。宝塔中共保存着n个宝藏，
    // 价值分别为a1, a2, . . . , an。每天冒险家可以进入宝塔，并选择一个价值不低于b的宝藏带出来。
    // 但是冒险家每天只能逃选择一个宝藏，而且每个宝藏只能被选择一次。现在小美想知道，在这个过程中，最多可以拿出多少个宝藏。
    //样例
    //12341
    //      ----> 4
    //31232
    public int findMoreTreasure(int[] values,int[] limits){
        int num=values.length;
        PriorityQueue<Integer> valueHeap=new PriorityQueue<>(num,(x, y)->(y-x));
        PriorityQueue<Integer> limitHeap=new PriorityQueue<>(num,(x,y)->(y-x));
        for (int i = 0; i < num; i++) {
            valueHeap.add(values[i]);
        }
        for (int i = 0; i < num; i++) {
            limitHeap.add(limits[i]);
        }
        int maxValue=0;
        while (!limitHeap.isEmpty()){
            if (limitHeap.peek()<=valueHeap.peek()){
                maxValue++;
                valueHeap.poll();
            }
            limitHeap.poll();
        }
        return maxValue;
    }
}
