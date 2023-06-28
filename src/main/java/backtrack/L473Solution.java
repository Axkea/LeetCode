package backtrack;

import java.util.Arrays;
public class L473Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum+=matchsticks[i];
        }
        if(sum%4!=0||sum==0){
            return false;
        }
        Arrays.sort(matchsticks);
        return backTrack(matchsticks,matchsticks.length-1,sum/4,new int[4]);
    }
    public boolean backTrack(int[] nums,int index,int taget,int[] size){
        if(index==nums.length){
            if(size[0]==size[1]&&size[1]==size[2]&&size[2]==size[3]){
                return true;
            }
            return false;
        }
        for (int i = 0; i < size.length; i++) {
            if(size[i]+nums[index]>taget){
                continue;
            }
            size[i]+=nums[index];
            if(backTrack(nums,index-1,taget,size)){
                return true;
            }
            size[i]-=nums[index];
        }
        return false;
    }
}
