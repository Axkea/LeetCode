package math;

public class L43Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1)||"0".equals(num2)) return "0";
        int n1=num1.length(),n2=num2.length();
        int[] value=new int[n1+n2];
        for (int i = n1-1; i >= 0; i--) {
            for (int j = n2-1; j >= 0; j--) {
                int index=n1-1+n2-1-i-j;
                value[index]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        for (int i = 0; i < n1+n2-1; i++) {
            value[i+1]+=value[i]/10;
            value[i]=value[i]%10;
        }
        int index=value.length-1;
        while(index>=0&&value[index]==0){
            index--;
        }
        StringBuilder res=new StringBuilder();
        while (index>=0){
            res.append(value[index]);
            index--;
        }
        return res.toString();
    }
}
