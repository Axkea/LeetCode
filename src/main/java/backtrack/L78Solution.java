package backtrack;

import java.util.ArrayList;
import java.util.List;

public class L78Solution {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> iList=new ArrayList<>();
        backTrace(nums.length,iList,nums);
        return res;
    }
    private void backTrace(int n,List<Integer> iList,int[] nums){
        if(n==0){
            res.add(new ArrayList<>(iList));
            return;
        }
        for (int i=0;i<2;i++){
            if(i==0){
                n--;
                backTrace(n,iList,nums);
                n++;
            }else{
                iList.add(nums[n-1]);
                n--;
                backTrace(n,iList,nums);
                n++;
                iList.remove(iList.size()-1);
            }
        }
    }
}
