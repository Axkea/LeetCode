package backtrack;

import java.util.ArrayList;
import java.util.List;

public class L46Solution {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> iList=new ArrayList<>();
        boolean[] flows=new boolean[nums.length];
        backTrace(iList,nums,flows);
        return res;
    }
    private void backTrace (List<Integer> iList,int[] nums,boolean[] flows){
        if(iList.size()==nums.length){
            res.add(new ArrayList<>(iList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flows[i]){
                continue;
            }
            iList.add(nums[i]);
            flows[i]=true;
            backTrace(iList,nums,flows);
            iList.remove(iList.size()-1);
            flows[i]=false;
        }
    }
}
