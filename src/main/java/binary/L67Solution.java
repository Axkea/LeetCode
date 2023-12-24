package binary;

import java.util.HashMap;

public class L67Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder=new StringBuilder();
        int len=a.length()>b.length()?a.length():b.length();
        int carry=0;
        for (int i = 0; i <len ; i++) {
            carry+=i<a.length()?(a.charAt(a.length()-i-1)-'0'):0;
            carry+=i<b.length()?(b.charAt(b.length()-i-1)-'0'):0;
            builder.append(carry%2);
            carry/=2;
        }
        if (carry==1){
            builder.append('1');
        }
        builder.reverse();
        return builder.toString();
    }
}
