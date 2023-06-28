package other;

import java.util.*;

public class L1207Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Set<Integer> set1=new HashSet<>();
        for(Map.Entry<Integer, Integer> i:entries){
            if (!set1.add(i.getValue())){
                return false;
            }
        }
        return true;
    }
}
