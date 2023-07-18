package string;

public class L14Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String res=strs[0];
        for (int i = 1; i < strs.length; i++) {
            res=longest2string(res,strs[i]);
        }
        return res;
    }
    private String longest2string(String s1,String s2){
        StringBuilder sb=new StringBuilder();
        int l=Math.min(s1.length(),s2.length());
        for (int i = 0; i < l; i++) {
            if (s1.charAt(i)==s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
