import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int left = 1;
        int right = distance;
        Arrays.sort(rocks);
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int tmp = 0;
            int cnt = 0;
            for (int rock : rocks) {
                if (rock - tmp < mid) {
                    cnt++;
                } else {
                    tmp = rock;
                }
            }
            
            if (distance - tmp < mid) cnt++;
            
            if (cnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
}
