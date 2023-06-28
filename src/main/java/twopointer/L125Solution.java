package twopointer;

public class L125Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        int start=0,end=s1.length()-1;
        while(start<end){
            while(start<=end&&!judgeAlpha(s1.charAt(start))){
                start++;
            }
            if(start>end){
                return true;
            }
            while(end>=0&&!judgeAlpha(s1.charAt(end))){
                end--;
            }
            if(start>end){
                return true;
            }
            if(s1.charAt(start)!=s1.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
    private boolean judgeAlpha(char c){
        return (c>='a'&&c<='z')||(c>='0'&&c<='9');
    }
}
