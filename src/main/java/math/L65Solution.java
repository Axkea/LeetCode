package math;

import java.util.HashMap;
import java.util.Map;

public class L65Solution {
    private String state="start";
    private Map<String,String[]> map=new HashMap<>();
    {
        map.put("start",new String[]{"invalid","num","dot","sign","invalid"});
        map.put("sign",new String[]{"invalid","num","dot","invalid","invalid"});
        map.put("dot",new String[]{"invalid","dotNum","invalid","invalid","invalid"});
        map.put("e",new String[]{"invalid","eNum","invalid","eSign","invalid"});
        map.put("invalid",new String[]{"invalid","invalid","invalid","invalid","invalid"});
        map.put("num",new String[]{"e","num","dotNum","invalid","invalid"});
        map.put("dotNum",new String[]{"e","dotNum","invalid","invalid","invalid"});
        map.put("eNum",new String[]{"invalid","eNum","invalid","invalid","invalid"});
        map.put("eSign",new String[]{"invalid","eNum","invalid","invalid","invalid"});
    }
    private void stateChange(char c){
        int index=4;
        if (Character.isDigit(c)){
            index=1;
        }else if (c=='e'||c=='E'){
            index=0;
        }else if (c=='.'){
            index=2;
        }else if (c=='+'||c=='-'){
            index=3;
        }
        state=map.get(state)[index];
    }
    public boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            stateChange(s.charAt(i));
        }
        return state=="dotNum"||state=="num"||state=="eNum";
    }
}
