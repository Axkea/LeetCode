package binarySearch;

public class S11Solution {
    public int minArray(int[] numbers) {
        int left=0,right=numbers.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(numbers[mid]<numbers[right]){
                right=mid;
            }else if(numbers[mid]>numbers[right]){
                left=mid+1;
            }else{
                right--;
            }
        }
        return numbers[left];
    }
}
