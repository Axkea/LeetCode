package hash;

import java.util.HashMap;


public class S50Solution {
    public char firstUniqChar(String s) {
        int n=s.length();char res=' ';
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            char c=s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,n);
                continue;
            }
            map.put(c,i);
        }
        int min=n;
        for (int i = 0; i < n; i++) {
            int now=map.get(s.charAt(i));
            if(min>now){
                min=now;
                res=s.charAt(min);
            }
        }
        return res;
    }
}
