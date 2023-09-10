package math;

public class L134Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length,sum=0,min=0,res=0;
        for (int i = 0; i < n; i++) {
            sum+=gas[i]-cost[i];
            if (sum<min){
                min=sum;
                res=i+1;
            }
        }
        return sum<0?-1:res;
    }
}
