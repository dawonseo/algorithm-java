import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BeakJoon1012 {

    static boolean[][] arr;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                arr[X][Y] = true;
            }

            cnt = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j]) {
                        cnt++;
                        BFS(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {i, j});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length) {
                    if (arr[nx][ny]) {
                        arr[nx][ny] = false;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
