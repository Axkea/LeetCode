package backtrack;

import java.util.ArrayList;
import java.util.List;

public class L17Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if (digits.length()==0){
            return res;
        }
        recursion(new StringBuilder(),digits,0,res);
        return res;
    }
    private void recursion(StringBuilder res,String digits,int index,List<String> resou){
        if(index==digits.length()){
            resou.add(new String(res));
            return;
        }
        Integer integer = Integer.valueOf(digits.charAt(index))-48;
        index++;
        if(integer==7){
            for (int i = 112; i < 116; i++) {
                char c=(char)i;
                res.append(c);
                recursion(res,digits,index,resou);
                res.deleteCharAt(res.length()-1);
            }
        }else if(integer==8){
            for (int i = 116; i < 119; i++) {
                char c=(char)i;
                res.append(c);
                recursion(res,digits,index,resou);
                res.deleteCharAt(res.length()-1);
            }
        }else if(integer==9){
            for (int i = 119; i < 123; i++) {
                char c=(char)i;
                res.append(c);
                recursion(res,digits,index,resou);
                res.deleteCharAt(res.length()-1);
            }
        }else{
            for (int i = 3*integer+91; i < 3*integer+94; i++) {
                char c=(char)i;
                res.append(c);
                recursion(res,digits,index,resou);
                res.deleteCharAt(res.length()-1);
            }
        }
    }
}
