package array;

import java.util.Arrays;

public class Sort {
    public static void bubbleSort(int[] nums){
        int n=nums.length;
        for (int i = n-1; i >1 ; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j]>nums[j+1]){
                    change_position(nums,j+1,j);
                }
            }
        }
    }
    public static void chooseSort(int[] nums){
        int n=nums.length;
        for (int i=0;i<n;i++){
            int index=i;
            for (int j = i; j < n; j++) {
                if (nums[index]>nums[j]){
                    index=j;
                }
            }
            change_position(nums,i,index);
        }
    }
    public static void insertSort(int[] nums){
        int n=nums.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            int temp=nums[i];
            for (; j >0 ; j--) {
                if(temp>nums[j-1]){
                    break;
                }else{
                   nums[j]=nums[j-1];
                }
            }
            nums[j]=temp;
        }
    }
    public static void quickSort(int[] nums,int begin,int end){
        if(begin<end){
            int j=begin;int key=nums[begin];
            for (int i = begin+1; i <=end; i++) {
                if (key>nums[i]){
                    change_position(nums,i,++j);
                }
            }
            nums[begin]=nums[j];
            nums[j]=key;
            quickSort(nums,begin,j-1);
            quickSort(nums,j+1,end);
        }
    }
    public static void quickSort1(int[] nums,int start,int end){
        if(start<end){
            int pivot=partition(nums,start,end);
            quickSort1(nums,start,pivot-1);
            quickSort1(nums,pivot+1,end);
        }
    }
    public static void mergeSort(int[] nums,int left,int right){
        if(left<right){
            int center=(left+right)>>1;
            mergeSort(nums,left,center);
            mergeSort(nums,center+1,right);
            merge(nums,left,center,right);
        }
    }
    private static void merge(int[] data,int left,int center,int right){
        int length=right-left+1,start0=left,start1=center+1,start2=0;
        int[] res=new int[length];
        while(start0<=center&&start1<=right){
            if (data[start0]>data[start1]){
                res[start2++]=data[start1++];
            }else{
                res[start2++]=data[start0++];
            }
        }
        while(start0<=center){
            res[start2++]=data[start0++];
        }
        while(start1<=right){
            res[start2++]=data[start1++];
        }
        int start3=0;
        while(start3<length){
            data[left++]=res[start3++];
        }
    }
    private static int partition(int[] nums,int start,int end){
        int pivot=nums[start];
        while(start<end){
            while(start<end&&pivot<=nums[end]){
                end--;
            }
            change_position(nums,start,end);
            while(start<end&&pivot>=nums[start]){
                start++;
            }
            change_position(nums,start,end);
        }
        return start;
    }
    private static void change_position(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
