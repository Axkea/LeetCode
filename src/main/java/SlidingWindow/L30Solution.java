package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L30Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int one_length=words[0].length(),words_length=words.length,all_length=one_length*words_length;
        for (int i = 0; i < s.length()-all_length+1; i++) {
            String tmp=s.substring(i,i+all_length);
            Map<String,Integer> window=new HashMap<>();
            for (int k = 0; k < all_length; k+=one_length) {
                String substr=tmp.substring(k,k+one_length);
                window.put(substr, window.getOrDefault(substr,0)+1);
            }
            if (window.equals(map))res.add(i);
        }
        return res;
    }
}
