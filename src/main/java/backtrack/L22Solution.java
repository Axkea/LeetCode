package backtrack;

import java.util.ArrayList;
import java.util.List;

public class L22Solution {
    private List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTrance(new StringBuilder(),0,0,n);
        return res;
    }
    private void backTrance(StringBuilder sb,int left,int right,int n){
        if(sb.length()==2*n){
            res.add(sb.toString());
        }
        if(left<n){
            sb.append("(");
            backTrance(sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(")");
            backTrance(sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
