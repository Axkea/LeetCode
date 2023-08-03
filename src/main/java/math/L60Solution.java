package math;

import java.util.ArrayList;
import java.util.List;

public class L60Solution {
    public String getPermutation(int n, int k) {
        k--;
        int[] fac=new int[n];
        fac[0]=1;
        for (int i = 1; i < n; i++) {
            fac[i]=fac[i-1]*i;
        }
        List<Integer> nums=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }
        int facI=n-1;
        StringBuilder builder=new StringBuilder();
        while (facI>=0){
            int num=k/fac[facI];
            builder.append(nums.remove(num));
            k-=num*fac[facI];
            facI--;
        }
        return builder.toString();
    }
}
