package twopointer;

import java.util.ArrayList;
import java.util.List;

public class S57Solution2_2 {
    public int[][] findContinuousSequence(int target) {
        List<ArrayList<Integer>> list=new ArrayList<>();
        int start=1,end=1,resu=1;
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        while(end<target/2+2){
            while(resu>target){
                resu-=list1.remove(0);
                start++;
            }
            if(resu==target){
                list.add(new ArrayList<>(list1));
            }
            end++;
            resu+=end;
            list1.add(end);
        }
        int[][] res=new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> arrayList = list.get(i);
            int[] res1=new int[arrayList.size()];
            for (int j = 0; j < arrayList.size(); j++) {
                res1[j]=arrayList.get(j);
            }
            res[i]=res1;
        }
        return res;
    }
}
