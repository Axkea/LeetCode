package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51Solution {
    private List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<StringBuffer> sList =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb=new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(" ");
            }
            sList.add(sb);
        }
        int[] count_flow=new int[n];
        Arrays.fill(count_flow,n);
        backTrace(sList,0,count_flow,n);
        return res;
    }
    private void backTrace(List<StringBuffer> sList,int flow,int[] count_flow,int n){
        if(flow==n||count_flow[flow]<=0){
            if(flow==n){
                fill_all(sList,n);
                res.add(change_StringBuffer(sList));
            }
            return;
        }
        int last=-1;
            for (int i = 0; i < n; i++) {
                List<StringBuffer> new_List=copy_sList(sList);
                StringBuffer sb = new_List.get(flow);
                int[] new_count=new int[n];
                System.arraycopy(count_flow,0,new_count,0,n);
                if(last!=-1){
                    sb.replace(last,last+1,".");
                }
                if(sb.charAt(i)!='.'){
                    sb.replace(i,i+1,"Q");
                    modify(new_List,i,flow,n,new_count);
                    flow++;
                    last=i;
                    backTrace(new_List,flow,new_count,n);
                    flow--;
                }
            }
    }
    private List<String> change_StringBuffer(List<StringBuffer> sList){
        List<String> str_List=new ArrayList<>();
        for (StringBuffer sb:sList){
            str_List.add(new String(sb));
        }
        return str_List;
    }
    private void modify(List<StringBuffer> slist,int x,int y,int n,int[] count_flow){
        StringBuffer stringBuffer = slist.get(y);
        for (int i = 0; i < n; i++) {
            if(stringBuffer.charAt(i)=='.'){
                count_flow[y]--;
            }
        }
        for (int i = y+1; i < n; i++) {
            StringBuffer stringBuffer1 = slist.get(i);
            if (stringBuffer1.charAt(x)!='.'){
                stringBuffer1.replace(x,x+1,".");
                count_flow[i]--;
            }
            if(x+i-y<n&&stringBuffer1.charAt(x+i-y)!='.'){
                stringBuffer1.replace(x+i-y,x+i-y+1,".");
                count_flow[i]--;
            }
            if(x-i+y>=0&&stringBuffer1.charAt(x-i+y)!='.'){
                stringBuffer1.replace(x-i+y,x-i+y+1,".");
                count_flow[i]--;
            }
        }
    }
    private List<StringBuffer> copy_sList(List<StringBuffer> sList){
        List<StringBuffer> new_List=new ArrayList<>();
        for(StringBuffer sb:sList){
            new_List.add(new StringBuffer(sb));
        }
        return new_List;
    }
    private void fill_all(List<StringBuffer> sList,int n){
        for (int j = 0; j < n; j++) {
            StringBuffer stringBuffer = sList.get(j);
        for (int i = 0; i < n; i++) {
            if(stringBuffer.charAt(i)==' '){
                stringBuffer.replace(i,i+1,".");
            }
        }
        }
    }
}
