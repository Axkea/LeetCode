package backtrack;

import java.util.ArrayList;
import java.util.List;

public class L842Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res=new ArrayList<>();
        backtrace(res,num,0);
        return res;
    }
    private void backtrace(List<Integer> res,String num,int index){
        if(index==num.length()&&res.size()>=3){
            return ;
        }
        for (int i = index+1; i < num.length(); i++) {

        }
    }
}
