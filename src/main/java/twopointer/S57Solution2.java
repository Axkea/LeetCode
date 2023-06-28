package twopointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S57Solution2 {
    public int[][] findContinuousSequence(int target) {
        List<ArrayList<Integer>> list=new ArrayList<>();
        for (int i = 1; i < target/2+1; i++) {
            int resu=0;ArrayList<Integer> list1=new ArrayList<>();
            for (int j = i; j < target/2+2; j++) {
                resu+=j;
                list1.add(j);
                if(resu>=target){
                    if(resu==target){
                        list.add(list1);
                    }
                    break;
                }
            }
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
