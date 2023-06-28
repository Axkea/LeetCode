package hash;

import java.util.HashSet;

public class S48Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        int maxSize=0;int p=0;
        for (int i = 0; i < n; i++) {
            if (!set.add(s.charAt(i))){
                char c = s.charAt(p);
                while(c !=s.charAt(i)){
                    set.remove(c);
                    p++;
                    c=s.charAt(p);
                }
                p++;
            }
            maxSize=Math.max(maxSize,set.size());
        }
        return maxSize;
    }
}
