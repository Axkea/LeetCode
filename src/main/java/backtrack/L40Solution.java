package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40Solution {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> iList=new ArrayList<>();
        Arrays.sort(candidates);
        backTrace(iList,candidates,target,-1);
        return res;
    }
    void backTrace(List<Integer> iList,int[] candidates,int target,int flow){
        if(target<=0){
            if (target==0){
                res.add(new ArrayList<>(iList));
                return;
            }
            return;
        }
        for (int i = flow+1; i < candidates.length; i++) {
            if (i>flow+1&&candidates[i]==candidates[i-1]){
                    continue;
            }
            target-=candidates[i];
            iList.add(candidates[i]);
            backTrace(iList,candidates,target,i);
            iList.remove(iList.size()-1);
            target+=candidates[i];
        }
    }
}
