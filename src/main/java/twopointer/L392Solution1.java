package twopointer;

public class L392Solution1 {
    public boolean isSubsequence(String s, String t) {
        int sp=0,st=0;
        while(st!=t.length()&&sp!=s.length()){
            if(s.charAt(sp)==t.charAt(st)){
                sp++;
                st++;
            }else{
                st++;
            }
        }
        return sp==s.length();
    }
}
