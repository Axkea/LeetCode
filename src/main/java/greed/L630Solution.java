package greed;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L630Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
        int allTime=0;
        for(int[] course:courses){
            int dur=course[0],ddl=course[1];
            if(allTime+dur<=ddl){
                allTime+=dur;
                queue.offer(dur);
            }else if(!queue.isEmpty()&&queue.peek()>dur){
                allTime-=queue.poll()-dur;
                queue.offer(dur);
            }
        }
        return queue.size();
    }
}
