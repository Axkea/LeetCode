package twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L438Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> change=new HashMap<>();
        //将要求异位词的字符串放入map中
        for (char c:p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int valid=0,left=0,right=0;
        //设置窗口的边界
        while(right<s.length()){
            char c=s.charAt(right);
            right++;
            if(map.containsKey(c)){
                change.put(c,change.getOrDefault(c,0)+1);
                if(change.get(c).equals(map.get(c))){
                    valid++;
                }
            }
            while((right-left)==p.length()){
                if(valid==map.size()){
                    res.add(left);
                }
                char c1=s.charAt(left);
                left++;
                if(map.containsKey(c1)){
                    if(map.get(c1).equals(change.get(c1))){
                        valid--;
                    }
                    change.put(c1,change.get(c1)-1);
                }
            }
        }
        return res;
    }
}
