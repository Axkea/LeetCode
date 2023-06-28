package backtrack;

import java.util.ArrayList;
import java.util.List;

public class L22Solution {
    public List<String> generateParenthesis(int n) {
        List<String> sList=new ArrayList<>();
        backTrace(n,new StringBuilder("("),1,0,sList);
        return sList;
    }
    public void backTrace(int n,StringBuilder res,int left,int right,List<String> sList){
        if(res.length()==2*n){
            sList.add(new String(res));
            return;
        }
        if(left==n){
            res.append(")");
            backTrace(n,res,left,right+1,sList);
            res.deleteCharAt(res.length()-1);
        }else if(left==right){
            res.append("(");
            backTrace(n,res,left+1,right,sList);
            res.deleteCharAt(res.length()-1);
        }else {
            for (int i = 0; i < 2; i++) {
                if (i==0){
                    res.append("(");
                    backTrace(n,res,left+1,right,sList);
                    res.deleteCharAt(res.length()-1);
                }else{
                    res.append(")");
                    backTrace(n,res,left,right+1,sList);
                    res.deleteCharAt(res.length()-1);
                }
            }
        }
    }
}
