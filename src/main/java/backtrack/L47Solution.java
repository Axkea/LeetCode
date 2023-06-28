package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L47Solution {
    private List<List<Integer>> res;
    private boolean[] visit;
    private HashSet<List<Integer>> hres=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        visit=new boolean[nums.length];
        List<Integer> iList =new ArrayList<>();
        backTrace(nums,iList);
        return res;
    }
    private void backTrace(int[] nums,List<Integer> iList){
        if(iList.size()==nums.length){
            hres.add(new ArrayList<>(iList));
            res=new ArrayList<>(hres);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]){
                continue;
            }
            iList.add(nums[i]);
            visit[i]=true;
            backTrace(nums, iList);
            visit[i]=false;
            iList.remove(iList.size()-1);
        }
    }
}
