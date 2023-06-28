package backtrack;

import java.util.ArrayList;
import java.util.List;

public class L39Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists =new ArrayList<>();
        List<Integer> cList=new ArrayList<>();
        backTrace(candidates,target,0,cList,lists,0);
        return lists;
    }
    void backTrace(int[] candidates,int target,int nowCount,List<Integer> c_List,List<List<Integer>> lists,int nowFlow){
        if (nowCount>=target){
            if (nowCount==target){
                List<Integer> list=new ArrayList<>(c_List);
                lists.add(list);
                return;
            }
            return;
        }
        for (int i = nowFlow; i < candidates.length; i++) {
            nowCount+=candidates[i];
            c_List.add(candidates[i]);
            backTrace(candidates,target,nowCount,c_List,lists,i);
            c_List.remove(c_List.size()-1);
            nowCount-=candidates[i];
        }
    }
}
