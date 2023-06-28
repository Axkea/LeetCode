package split_merge;

import java.util.ArrayList;
import java.util.List;

public class L241Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List res=split(expression);
        return res;
    }
    private List<Integer> split(String input){
        List res=new ArrayList();
        int n=input.length();
        if(!input.contains("+")&&!input.contains("-")&&!input.contains("*")){
            res.add(Integer.valueOf(input));
            return res;
        }
        for (int i = 0; i < n; i++) {
            if(input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'){
                for(int j:split(input.substring(0,i))){
                    for (int k:split(input.substring(i+1,n))){
                        if(input.charAt(i)=='+'){
                            res.add(j+k);
                        }else if(input.charAt(i)=='-'){
                            res.add(j-k);
                        }else{
                            res.add(j*k);
                        }
                    }
                }
            }
        }
        return res;
    }
}
