import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2667 {

    static int N;
    static int[][] arr;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> houseCounts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int cntOfComplex = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    cntOfComplex++;
                    houseCounts.add(BFS(i, j));
                }
            }
        }

        Collections.sort(houseCounts);
        sb.append(cntOfComplex).append("\n");

        for (int count : houseCounts) {
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static int BFS(int x, int y) {
        int cnt = 1;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y});
        arr[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length) {
                    if (arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        cnt++;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        return cnt;
    }
}
