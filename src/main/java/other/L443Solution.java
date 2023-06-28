package other;

public class L443Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        char pre= ' ';int count=0;int len=chars.length;
        for (int i = 0; i <= len; i++) {
            if(i!=len&&chars[i]==pre){
                count++;
            }else {
                if(pre!=' '||i==len){
                    if(count<=1){
                        sb.append(pre);
                    }else{
                        sb.append(pre);
                        sb.append(count);
                    }
                    if(i==len){
                        break;
                    }
                }
                pre=chars[i];
                count=1;
            }
        }
        char[] chars1=new String(sb).toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            chars[i]=chars1[i];
        }
        return sb.length();
    }
}
