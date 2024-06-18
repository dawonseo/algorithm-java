import java.util.*;

class Solution {
    static int[] answer = new int[4];
    public int[] solution(int[][] edges) {
        int n = edges.length;
        Map<Integer, int[]> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            if (!hm.containsKey(a)) {
                hm.put(a, new int[] {0, 0});
            }
            if (!hm.containsKey(b)) {
                hm.put(b, new int[] {0, 0});
            }
            hm.get(a)[0]++;
            hm.get(b)[1]++;
        }
        
        int[] tmp;
        
        for (int key : hm.keySet()) {
            tmp = hm.get(key);
            
            if (tmp[0] == 0) {
                answer[2]++;
            }
            
            if (tmp[1] == 0 && tmp[0] >= 2) {
                answer[0] = key;
            }
            
            if (tmp[1] >= 2 && tmp[0] == 2) {
                answer[3]++;
            }
        }
        
        answer[1] = hm.get(answer[0])[0] - answer[2] - answer[3];
        return answer;
    }
}
