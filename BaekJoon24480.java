import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon24480 {
    static int[] visited;
    static PriorityQueue<Integer>[] arr;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 개수
        int N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());
        // 시작 정점
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        arr = new PriorityQueue[N + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].offer(v);
            arr[v].offer(u);
        }

        visited[R] = 1;
        dfs(R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
    }

    static void dfs(int R) {
        while (!arr[R].isEmpty()) {
            int t = arr[R].poll();
            if (visited[t] == 0) {
                cnt++;
                visited[t] = cnt;
                dfs(t);
            }
        }
    }
}
