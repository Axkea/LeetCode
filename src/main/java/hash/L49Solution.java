package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L49Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            int[] alpha=new int[26];
            for (int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i)-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(alpha[i]);
            }
            String key=sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

