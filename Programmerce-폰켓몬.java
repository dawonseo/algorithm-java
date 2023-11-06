import java.util.HashSet;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        
        int ans = (int) nums.length / 2;
        
        if (hs.size() < ans) {
            ans = hs.size();
        }
        
        return ans;
    }
}
