package dp;

public class L121Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0],sub=0;
        for (int i = 0; i < prices.length; i++) {
            if (sub<prices[i]-min){
                sub=prices[i]-min;
            }
            if (min>prices[i]){
                min=prices[i];
            }
        }
        return sub;
    }
}
