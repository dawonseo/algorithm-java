import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10971 {
    static int N;
    static int[][] W;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        W = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        visited[0] = true; // 시작점 방문 처리

        DFS(0, 0, 0, visited);

        System.out.println(ans);
    }

    private static void DFS(int cur, int cnt, int cost, boolean[] visited) {
        if (cost >= ans) return;

        if (cnt == N - 1) {
            if (W[cur][0] != 0) {
                ans = Math.min(ans, cost + W[cur][0]);
            }
            return;
        }

        for (int k = 0; k < N; k++) {
            if (W[cur][k] != 0 && !visited[k]) {
                visited[k] = true;
                DFS(k, cnt + 1, cost + W[cur][k], visited);
                visited[k] = false;
            }
        }
    }
}
