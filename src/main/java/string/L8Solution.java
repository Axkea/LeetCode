package string;

import java.util.HashMap;
import java.util.Map;

public class L8Solution {
    public int myAtoi(String s) {
        Automaton automaton=new Automaton();
        for (char c:s.toCharArray()){
            automaton.changeState(c);
        }
        return (int)(automaton.sign* automaton.res);
    }
    class Automaton{
        int sign=1;
        long res=0l;
        String state="start";
        Map<String,String[]> map=new HashMap<>();
        {
            map.put("start",new String[]{"start","signed","number","end"});
            map.put("signed",new String[]{"end","end","number","end"});
            map.put("number",new String[]{"end","end","number","end"});
            map.put("end",new String[]{"end","end","end","end"});
        }
        public void changeState(char c){
            int col=getCol(c);
            state= map.get(state)[col];
            if (state=="number"){
                res=res*10+c-'0';
                res=sign==1?Math.min(res,Integer.MAX_VALUE):Math.min(res,-(long)Integer.MIN_VALUE);
            }else if (state=="signed"){
                if (c=='-'){
                    sign=-sign;
                }
            }
        }
        public int getCol(char c){
            if (c=='+'||c=='-'){
                return 1;
            }
            if (c==' '){
                return 0;
            }
            if (Character.isDigit(c)){
                return 2;
            }
            return 3;
        }
    }
}
