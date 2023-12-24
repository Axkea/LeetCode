package array;

public class SortREW {
    public static void bubbleSort(int[] nums){
        for (int i = nums.length-1; i >-1 ; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j]>nums[j+1]){
                    changePosition(nums,j,j+1);
                }
            }
        }
    }
    public static void chooseSort(int[] nums){
        for (int i = nums.length-1; i >-1 ; i--) {
            int max=0;
            for (int j = 0; j <=i; j++) {
                if (nums[max]<nums[j]){
                    max=j;
                }
            }
            changePosition(nums,i,max);
        }
    }
    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
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
    private static int quickSort(int[] nums,int start,int end){
        int pivot=nums[start];
        while(start<end){
            while(start<end&&nums[end]>=pivot){
                end--;
            }
            changePosition(nums,start,end);
            while(start<end&&nums[start]<=pivot){
                start++;
            }
            changePosition(nums,start,end);
        }
        return start;
    }
    public static void mainQuickSort(int[] nums,int start,int end){
        if(start<end){
            int pivot=quickSort(nums,start,end);
            mainQuickSort(nums,start,pivot-1);
            mainQuickSort(nums,pivot+1,end);
        }
    }
    public static void quickSort1(int[] nums,int start,int end){
        if(start<end){
            int index=start;int pivot=nums[start];
            for (int i = start+1; i <=end ; i++) {
                if(nums[i]<pivot){
                    changePosition(nums,++index,i);
                }
            }
            nums[start]=nums[index];
            nums[index]=pivot;
            quickSort1(nums,start,index-1);
            quickSort1(nums,index+1,end);
        }
    }
    private static void changePosition(int[] nums,int i ,int j){
        if (nums[i]==nums[j]){
            return;
        }
        nums[i]=nums[i]^nums[j];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[i]^nums[j];
    }

    public static void quickSort2(int[] nums,int start,int end){
        if (start<end){
            int index=start,key=nums[start];
            for (int i = start+1; i <= end ; i++) {
                if (nums[i]<key){
                    int temp=nums[i];
                    nums[i]=nums[++index];
                    nums[index]=temp;
                }
            }
            nums[start]=nums[index];
            nums[index]=key;
            quickSort2(nums, start, index-1);
            quickSort2(nums, index+1, end);
        }
    }
}
