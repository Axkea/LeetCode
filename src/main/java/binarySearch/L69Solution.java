package binarySearch;

public class L69Solution {
    public int mySqrt(int x) {
        int low=0,high=x;
        if(x<=1){
            return x;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid*mid==x){
                return mid;
            }
            if(mid>x/mid){
                high=mid-1;
            }else{
                if((mid+1)>x/(mid+1)){
                    return mid;
                }else{
                    low=mid+1;
                }
            }
        }
        return low;
    }
}
