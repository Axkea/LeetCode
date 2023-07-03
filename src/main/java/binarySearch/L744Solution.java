package binarySearch;

public class L744Solution {
//    public char nextGreatestLetter(char[] letters, char target) {
//        int low=0,high=letters.length-1;
//        while(low<=high){
//            int mid=low+(high-low)/2;
//            if(letters[mid]<=target){
//                low=mid+1;
//            }else{
//                if(mid==0||letters[mid-1]<=target){
//                    return letters[mid];
//                }else{
//                    high=mid-1;
//                }
//            }
//        }
//        return letters[0];
//    }
    public char nextGreatestLetter(char[] letters, char target){
        int start=0,end=letters.length-1;
        while (start<end){
            int mid=start+(end-start)/2;
            if(letters[mid]<=target){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return target<letters[start]?letters[start]:letters[0];
    }
}
