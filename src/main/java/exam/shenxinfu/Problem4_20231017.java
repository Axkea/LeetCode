package exam.shenxinfu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Problem4_20231017 {
    public String substr (String a, String b) {
        int bLen=b.length();
        HashMap<Character,Integer> bMap=new HashMap<>();
        HashMap<Character,Integer> aMap=new HashMap<>();
        for (int i = 0; i < bLen; i++) {
            char c=b.charAt(i);
            bMap.put(c,bMap.getOrDefault(c,0)+1);
        }
        int l=0,r=-1;
        int length=Integer.MAX_VALUE;
        int al=-1,ar=-1;
        int aLen=a.length();
        while (r<aLen){
            r++;
            if (r<aLen&&bMap.containsKey(a.charAt(r))){
                aMap.put(a.charAt(r),aMap.getOrDefault(a.charAt(r),0)+1);
            }
            while (mapContains(aMap,bMap)&&l<=r){
                if (r-l+1<length){
                    length=r-l+1;
                    al=l;
                    ar=l+length;
                }
                if (bMap.containsKey(a.charAt(l))){
                    aMap.put(a.charAt(l), aMap.getOrDefault(a.charAt(l),0)-1);
                }
                l++;
            }
        }
        return al==-1?"":a.substring(al,ar);
    }
    public boolean mapContains(HashMap<Character,Integer> aMap,HashMap<Character,Integer> bMap){
        Iterator<Map.Entry<Character, Integer>> iterator = bMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (aMap.getOrDefault(key,0)<value){
                return false;
            }
        }
        return true;
    }
}
