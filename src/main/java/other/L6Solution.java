package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L6Solution {
    public String convert(String s, int numRows) {
        if(numRows<2)return s;
        List<StringBuilder> lists=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new StringBuilder());
        }
        int flag=-1,i=0;
        for(char c:s.toCharArray()){
            lists.get(i).append(c);
            if (i==0||i==numRows-1) flag=-flag;
            i+=flag;
        }
        StringBuilder res=new StringBuilder();
        for (StringBuilder sb:lists){
            res.append(sb);
        }
        return res.toString();
    }
}
