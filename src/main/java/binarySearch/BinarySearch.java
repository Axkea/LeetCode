package binarySearch;

import java.util.List;

public class BinarySearch {
    public int search1(int[] array,int target){
        int low=0,high=array.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==array[mid]){
                return mid;
            }
            if(target>array[mid]){
                low=mid+1;
            }else if(target<array[mid]){
                high=mid-1;
            }
        }
        return low;
    }
    //方法二
    public int search2(int[] array,int target){
        int low=0,high=array.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(array[mid]<target){
                low=mid+1;
            }else if(array[mid]>=target){
                high=mid;
            }
        }
        return low;
    }
    public int search3(int[] array,int target){
        int low=0,high=array.length-1;
        while(low<high){
            int mid=low+(high-low+1)/2;
            if(array[mid]<=target){
                low=mid;
            }else if(array[mid]>target){
                high=mid-1;
            }
        }
        return low;
    }
    //方法三
    public int binarySearch(List<Integer> list, int low, int target) {
        int high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
