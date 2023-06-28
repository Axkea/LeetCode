package hash;

import java.util.HashSet;

public class L217Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hset=new HashSet<>();
        for (int i:nums) {
            if (!hset.add(i)) {
                return true;
            }
        }
        return false;
    }
}
