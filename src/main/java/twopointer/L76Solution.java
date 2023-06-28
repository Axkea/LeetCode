package twopointer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class L76Solution {
    public String minWindow(String s, String t) {
        String res="";
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> change=new HashMap<>();
        int valid=0;
        for (Character c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        while(right<s.length()){
            char c=s.charAt(right);
            right++;
            change.put(c,change.getOrDefault(c,0)+1);
            if(change.get(c).equals(map.getOrDefault(c,0))){
                valid++;
            }
            while(valid==map.size()){
                if(res==""){
                    res=s.substring(left,right);
                }
                char c1=s.charAt(left);
                left++;
                if(map.containsKey(c1)&&map.get(c1).equals(change.get(c1))){
                    valid--;
                }
                change.put(c1,change.get(c1)-1);
                if(valid== map.size()&&(right-left)<res.length()){
                    res=s.substring(left,right);
                }
            }
        }
        return res;
    }
}
