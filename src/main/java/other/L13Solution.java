package other;

import java.util.HashMap;
import java.util.Map;

public class L13Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);map.put('V',5);
        map.put('X',10);map.put('L',50);
        map.put('C',100);map.put('D',500);
        map.put('M',1000);
        int max=1,res=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            Integer integer = map.get(s.charAt(i));
            if (integer>=max){
                res+=integer;
                max=integer;
            }else{
                res-=integer;
            }
        }
        return  res;
    }
}
