import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int n = friends.length;
        int[][] m = new int[n][n];
        HashMap<String, Integer> indexMap = new HashMap<>();
        int[] presentPoint = new int[n];
        int[] p = new int[n];
        
        for (int i = 0; i < n; i++) {
            indexMap.put(friends[i], i);
        }
        
        StringTokenizer st;
        
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            int a = indexMap.get(st.nextToken());
            int b = indexMap.get(st.nextToken());
            
            m[a][b]++;
            presentPoint[a]++;
            presentPoint[b]--;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (m[i][j] > m[j][i]) {
                    p[i]++;
                } else if (m[i][j] < m[j][i]) {
                    p[j]++;
                } else {
                    if (presentPoint[i] > presentPoint[j]) {
                        p[i]++;
                    } else if (presentPoint[i] < presentPoint[j]) {
                        p[j]++;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (p[i] > answer) answer = p[i];
        }
        

        return answer;
    }
}
