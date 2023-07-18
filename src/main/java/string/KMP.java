package string;

import java.util.Arrays;

public class KMP {
    private String pat;
    private int[] next;

    public KMP(String pat) {
        this.pat = pat;
        next=new int[pat.length()];
        buildNext();
    }
    private void buildNext(){
        int j =0;
        next[0]=0;
        for (int i = 1; i < pat.length(); i++) {
            while (j>0&&pat.charAt(i)!=pat.charAt(j)) j=next[j-1];
            if (pat.charAt(i)==pat.charAt(j)) j++;
            next[i]=j;
        }
    }
    public int search(String line){
        if (pat.length()==0){
            return 0;
        }
        int j=0;
        for (int i = 0; i < line.length(); i++) {
            while (j>0&&line.charAt(i)!=pat.charAt(j)){
                j=next[j-1];
            }
            if (line.charAt(i)==pat.charAt(j)){
                j++;
            }
            if (j==pat.length()){
                return i-pat.length()+1;
            }
        }
        return -1;
    }
}
