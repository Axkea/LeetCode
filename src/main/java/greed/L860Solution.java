package greed;

public class L860Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] contains=new int[2];
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]-5==0){
                contains[0]++;
            }else if(bills[i]-10==0){
                if(contains[0]<1){
                    return false;
                }
                contains[0]--;
                contains[1]++;
            }else{
                if(contains[1]<1){
                    if(contains[0]<3){
                        return false;
                    }
                    contains[0]-=3;
                }else{
                    if(contains[0]<1){
                        return false;
                    }
                    contains[1]--;
                    contains[0]--;
                }
            }
        }
        return true;
    }
}
