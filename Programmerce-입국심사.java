class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long)times[times.length-1] * n;
        
        while (left < right) {
            long mid = (left + right) / 2;
            long t = 0;
            for (int cur : times) {
                t += (mid / (long)cur);
            }
            
            if (t >= n) {
                right = mid;
            } else {
                left = mid + 1;
            } 
        }
        
        return right;
    }
}
