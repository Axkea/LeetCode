package string;

import java.util.ArrayList;
import java.util.List;

public class L68Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int cnt=0,bg=0;
        for (int i = 0; i < words.length; i++) {
            cnt+=words[i].length()+1;
            if (i+1==words.length||cnt+words[i+1].length()>maxWidth){
                res.add(fullOneLine(words,bg,i,maxWidth,i+1==words.length));
                cnt=0;
                bg=i+1;
            }
        }
        return res;
    }
    private String fullOneLine(String[] words,int bg,int end,int maxWidth,boolean lastLine){
        int wordCount=end-bg+1;
        int spaceCount=maxWidth+1-wordCount;
        for (int i = bg; i <= end; i++) {
            spaceCount-=words[i].length();
        }
        int avgCount=wordCount==1?1:spaceCount/(wordCount-1);
        int remainCount=wordCount==1?0:spaceCount%(wordCount-1);
        StringBuilder builder=new StringBuilder();
        for (int i = bg; i <end ; i++) {
            builder.append(words[i]);
            if (lastLine){
                builder.append(' ');
                continue;
            }
            int count=avgCount+1+(i-bg<remainCount?1:0);
            while (count>0){
                builder.append(" ");
                count--;
            }
        }
        builder.append(words[end]);
        while (builder.length()<maxWidth){
            builder.append(" ");
        }
        return builder.toString();
    }
}
