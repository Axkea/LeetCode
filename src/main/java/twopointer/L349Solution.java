package twopointer;

import java.util.*;

public class L349Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> ilist=new HashSet<>();
        int n1=nums1.length,n2=nums2.length,index1=0,index2=0;
        while(index1!=n1&&index2!=n2){
            if(nums1[index1]==nums2[index2]){
                ilist.add(nums1[index1]);
                index1++;
                index2++;
            }else if(nums1[index1]>nums2[index2]){
                index2++;
            }else{
                index1++;
            }
        }
        int[] res=new int[ilist.size()];
        int index=0;
        for(Integer i:ilist){
            res[index]=i;
            index++;
        }
        return res;
    }
}
