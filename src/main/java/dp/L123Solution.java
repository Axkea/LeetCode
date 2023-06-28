package dp;

public class L123Solution {
    public int maxProfit(int[] prices) {
        int firstBuy=Integer.MIN_VALUE,firstSell=0;
        int secondBuy=Integer.MIN_VALUE,secondSell=0;
        for (int i = 0; i < prices.length; i++) {
            if(firstBuy<-prices[i]){
                firstBuy=-prices[i];
            }
            firstSell=Math.max(firstSell,prices[i]+firstBuy);
            if(secondBuy<firstSell-prices[i]){
                secondBuy=firstSell-prices[i];
            }
            secondSell=Math.max(secondSell,secondBuy+prices[i]);
        }
        return secondSell;
    }
}
