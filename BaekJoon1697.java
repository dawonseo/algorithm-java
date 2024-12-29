import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1697 {
    static int N, K;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {N, 0});
        visited[N] = true;

        int ans = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int idx = cur[0];
            int cnt = cur[1];

            if (idx == K) {
                ans = cnt;
                break;
            }

            if (0 <= idx - 1 && !visited[idx - 1]) {
                visited[idx - 1] = true;
                queue.offer(new int[] {idx - 1, cnt + 1});
            }
            if (idx + 1 <= 100000 && !visited[idx + 1]) {
                visited[idx + 1] = true;
                queue.offer(new int[] {idx + 1, cnt + 1});
            }
            if (0 <= idx * 2 && idx * 2 <= 100000 && !visited[idx * 2]) {
                visited[idx * 2] = true;
                queue.offer(new int[] {idx * 2, cnt + 1});
            }

        }
        return ans;
    }
}
