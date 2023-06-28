package backtrack;

import java.util.HashSet;
import java.util.Set;

public class S38Solution {
    public String[] permutation(String s) {
        Set<String> stringList=new HashSet<>();
        Set set=new HashSet();
        backTrack(stringList,s,set,"");
        String[] strings=new String[stringList.size()];
        int i=0;
        for (String ss:stringList){
            strings[i]=ss;
            i++;
        }
        return strings;
    }
    public void backTrack(Set<String> slist,String s,Set set,String res){
        if(set.size()==s.length()){
            slist.add(new String(res));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(!set.contains(i)){
                res+=s.charAt(i);
                set.add(i);
                backTrack(slist,s,set,res);
                res=res.substring(0,res.length()-1);
                set.remove(i);
            }
        }
    }
}
