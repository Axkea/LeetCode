package twopointer;

public class L4Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int m=nums1.length;
        int n=nums2.length;
        int leftAll=(m+n+1)/2;
        int left=0,right=m;
        while(left<right){
            //进行搜索
            int i=(left+right)/2;
            int j=leftAll-i;
            if(nums1[i]<nums2[j-1]){
                left=i+1;
            }else{
                right=i;
            }
        }
        int i=left;
        int j=leftAll-i;
        int n1=i-1==-1?Integer.MIN_VALUE:nums1[i-1];
        int n2=i==m?Integer.MAX_VALUE:nums1[i];
        int m1=j-1==-1?Integer.MIN_VALUE:nums2[j-1];
        int m2=j==n?Integer.MAX_VALUE:nums2[j];
        if((m+n)%2==0){
            return (double) (Math.max(n1,m1)+Math.min(n2,m2))/2;
        }else{
            return Math.max(n1,m1);
        }
    }
}
