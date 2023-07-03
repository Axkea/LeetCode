package binarySearch;

public class M1003Solution {
    public int search(int[] arr, int target) {
        int start=0,end=arr.length-1;
        while (end>0&&arr[end]==arr[0])end--;
        while(start<end){
            int mid=start+(end-start)/2;
            if(target==arr[mid]){
                end=mid;
            }else if(arr[start]<=arr[mid]){
                if(arr[start]<=target&&target<arr[mid]){
                    end=mid;
                }else{
                    start=mid+1;
                }
            }else{
                if(arr[mid]<target&&target<=arr[end]){
                    start=mid+1;
                }else{
                    end=mid;
                }
            }
        }
        return arr[start]==target?start:-1;
    }
}
