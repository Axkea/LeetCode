package other;

import java.util.HashMap;

public class L6Solution {
    public String convert(String s, int numRows) {
        HashMap<Integer,int[]> position=new HashMap<>();
        char[][] chars=new char[numRows][s.length()];
        int i;
        for (i = 0; i < numRows; i++) {
            chars[i][0]=s.charAt(i);
            int[] posi={i,0};
            position.put(i, posi);
        }
        int all=numRows-1;
        for (int j = i-2; j >0 ; j--) {
            chars[j][all-j]=s.charAt(i);
            int[] posi={j,all-j};
            position.put(i,posi);
            i++;
        }
        for(;i<s.length();i++){
            int[] ints = position.get(i - 2 * numRows + 2);
            chars[ints[0]][ints[1]+2]=s.charAt(i);
            int[] posi={ints[0],ints[1]+2};
            position.put(i,posi);
        }
        StringBuffer sb=new StringBuffer();
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < s.length(); k++) {
                if(chars[j][k]!='\0'){
                    sb.append(chars[j][k]);
                }
            }
        }
        return new String(sb);
    }
}
