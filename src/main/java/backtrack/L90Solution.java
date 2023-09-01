package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90Solution {
    private List<List<Integer>> finRes;
    private List<Integer> res;
    private boolean[] isUse;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        finRes=new ArrayList<>();
        res=new ArrayList<>();
        isUse=new boolean[nums.length];
        backTrance(nums,0);
        return finRes;
    }

    private void backTrance(int[] nums,int index){
        if (index== nums.length){
            finRes.add(new ArrayList<>(res));
            return;
        }
        backTrance(nums, index+1);
        if (index>0&&!isUse[index-1]&&nums[index]==nums[index-1]){
            return;
        }
        res.add(nums[index]);
        isUse[index]=true;
        backTrance(nums, index+1);
        isUse[index]=false;
        res.remove((Integer) nums[index]);
    }
}
