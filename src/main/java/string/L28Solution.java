package string;

public class L28Solution {
    public int strStr(String haystack, String needle) {
        int n1=haystack.length(),n2=needle.length();
        for (int i = 0; i < n1-n2; i++) {
            int p1=i,p2=0;
            while (p2<n2&&haystack.charAt(p1)==needle.charAt(p2)){
                p1++;
                p2++;
            }
            if (p2==n2) return i;
        }
        return -1;
    }
    public int strStrKMP(String haystack, String needle) {
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }
}
