package binarySearch;

public class L278Solution {
    private boolean isBadVersion(int n){
        return false;
    }

//    public int firstBadVersion(int n) {
//        int low=0,high=n;
//        while(low<=high){
//            int mid=low+(high-low)/2;
//            if(!isBadVersion(mid)){
//                low=mid+1;
//            }else{
//                if(mid==0||!isBadVersion(mid-1)){
//                    return mid;
//                }else{
//                    high=mid-1;
//                }
//            }
//        }
//        return low;
//    }
    public int firstBadVersion(int n){
        int start=0,end=n;
        while(start<end){
            int mid=start+(end-start)/2;
            if(isBadVersion(mid)){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}
