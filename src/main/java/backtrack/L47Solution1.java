package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47Solution1 {
    private List<List<Integer>> res=new ArrayList<>();
    private boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> iList=new ArrayList<>();
        vis=new boolean[nums.length];
        Arrays.sort(nums);
        return res;
    }
    private void backTrace(int[] nums,List<Integer> iList){
        if(iList.size()==nums.length){
            res.add(new ArrayList<>(iList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i]||(i!=0&&nums[i]==nums[i-1]&&!vis[i-1])){
                continue;
            }
            iList.add(nums[i]);
            vis[i]=true;
            backTrace(nums,iList);
            vis[i]=false;
            iList.remove(iList.size()-1);
        }
    }
}
