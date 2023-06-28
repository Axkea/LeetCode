package binarySearch;


public class S70Solution_2 {
    //利用中间插值会打断奇偶
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid < n - 1 && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    l = mid + 2;
                } else {
                    r = mid - 1;
                }
            } else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    r = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else {
                ans = nums[mid];
                break;
            }
        }
        // 由于题目的性质，ans一定会被找到，所以不会返回-1
        return ans;
    }
}
