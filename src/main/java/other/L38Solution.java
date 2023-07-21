package other;

public class L38Solution {
    public String countAndSay(int n) {
        String des="1";
        for (int i = 1; i < n ; i++) {
            int start=0,pos=0;
            StringBuilder res=new StringBuilder();
            while (pos<des.length()){
                while (pos<des.length()&&des.charAt(pos)==des.charAt(start)){
                    pos++;
                }
                res.append(pos-start).append(des.charAt(start));
                start=pos;
            }
            des=res.toString();
        }
        return des;
    }
}
