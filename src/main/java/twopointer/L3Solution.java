package twopointer;

import java.util.HashSet;

public class L3Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
        int right=0,resu=0;
        HashSet res=new HashSet();
        for(int i=0;i<length;i++){
            if(i!=0){
                res.remove(s.charAt(i-1));
            }
            while(right<length&&!res.contains(s.charAt(right))){
                res.add(s.charAt(right));
                right++;
            }
            resu=Math.max(resu,res.size());
        }
        return resu;
    }
    public int lengthOfLongestSubstring1(String s) {
        int n=s.length(),res=0,left=0,right=0;
        HashSet<Character> set=new HashSet<>();
        while(right<n){
            char c=s.charAt(right);
            if(set.add(c)){
                right++;
                if(right-left>res){
                    res=right-left;
                }
            }else{
                while(set.contains(c)){
                    char c1=s.charAt(left);
                    left++;
                    set.remove(c1);
                }
            }
        }
        return res;
    }
}
