package other;

import java.util.Arrays;

public class L60Solution {
    public String getPermutation(int n, int k) {
        char[] chars=new char[n];
        for (int i = 0; i < n; i++) {
            chars[i]=(char)(i+'1');
        }
        for (int i = 0; i < k-1; i++) {
            findNext(chars);
        }
        return new String(chars);
    }

    private void findNext(char[] fir){
        int j=0,k=0;
        for (int i = fir.length-1; i >0; i--) {
            if (fir[i-1]<fir[i]){
                j=i-1;
                break;
            }
        }
        for (int i = fir.length-1; i >=0; i--) {
            if (fir[i]>fir[j]){
                k=i;
                break;
            }
        }
        char tmp=fir[j];
        fir[j]=fir[k];
        fir[k]=tmp;
        reverse(fir,j+1,fir.length-1);
    }

    private void reverse(char[] fir,int start,int end){
        for (int i = start; i <= (start+end)/2; i++) {
            char tmp=fir[i];
            fir[i]=fir[end+start-i];
            fir[end+start-i]=tmp;
        }
    }
}
