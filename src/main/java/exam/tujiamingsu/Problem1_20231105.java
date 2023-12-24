package exam.tujiamingsu;

/**
 * @Author Axkea
 * @Date 2023/11/5/005 16:12
 * @Description
 */
public class Problem1_20231105 {
    private int max;
    private int column;
    public int maxBoxQty (int[] nums) {
        // write code here
        dfs(nums,0);
        return max;
    }

    public void dfs(int[] nums,int index){
        if (index==nums.length){
            if (column%3==0){
                max=Math.max(max,column/3);
            }
            return;
        }
        column+=nums[index];
        dfs(nums, index+1);
        column-=nums[index];
        dfs(nums,index+1);
    }

}
