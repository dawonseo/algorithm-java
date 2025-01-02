import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2206 {
    static int N, M;
    static int[][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp[j] - '0';
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        int[] dn = {1, -1, 0, 0};
        int[] dm = {0, 0, 1, -1};

        queue.offer(new int[] {0, 0, 0, 1});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[0];
            int m = cur[1];
            int check = cur[2];
            int cnt = cur[3];

            if (n == N - 1 && m == M - 1) {
                return cnt;
            }

            for (int k = 0; k < 4; k++) {
                int nn = n + dn[k];
                int nm = m + dm[k];

                if (0 <= nn && nn < N && 0 <= nm && nm < M) {
                    if (arr[nn][nm] == 0 && !visited[nn][nm][check]) {
                        queue.offer(new int[] {nn, nm, check, cnt + 1});
                        visited[nn][nm][check] = true;
                    } else if (arr[nn][nm] == 1 && check == 0 && !visited[nn][nm][1]) {
                        queue.offer(new int[] {nn, nm, 1, cnt + 1});
                        visited[nn][nm][1] = true;
                    }
                }
            }
        }

        return -1;
    }
}
