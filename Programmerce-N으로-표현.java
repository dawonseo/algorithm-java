import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        Set<Integer>[] s = new Set[9];
        
        int t = N;
        
        for (int i = 1; i < 9; i++) {
            s[i] = new HashSet<Integer>();
            s[i].add(t);
            t = t * 10 + N;
        }
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (Integer a : s[j]) {
                    for (Integer b : s[i - j]) {
                        s[i].add(a + b);
                        s[i].add(a - b);
                        s[i].add(b - a);
                        s[i].add(a * b);
                        if (b != 0) s[i].add(a / b);
                        if (a != 0) s[i].add(b / a);
                    }
                }
            }
        }
        
        for (int i = 1; i < 9; i++) {
            if (s[i].contains(number)) return i;
        }
        
        return -1;
    }
}
