package backtrack;

import java.util.ArrayList;
import java.util.List;

public class L77Solution {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> iList=new ArrayList<>();
        backTrace(n,k,iList,-1);
        return res;
    }
    private void backTrace(int n,int k,List<Integer> iList,int record){
        if (0==k){
            res.add(new ArrayList<>(iList));
            return;
        }
        for (int i=record+1; i < n; i++) {
            iList.add(i+1);
            backTrace(n,--k,iList,i);
            k++;
            iList.remove(iList.size()-1);
        }
    }
}
