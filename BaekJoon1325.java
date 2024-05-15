import java.io.*;
import java.util.*;

public class BaekJoon1325 {
    static int N, M;
    static boolean[] visited;
    static int[] ans;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int maxVal = 0;

        for (int i = 1; i <= N; i++) {
            maxVal = Math.max(ans[i], maxVal);
        }

        for (int i = 1; i <= N; i++) {
            if (ans[i] == maxVal) {
                System.out.print(i + " ");
            }
        }
    }

    public static void BFS(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int t = q.poll();

            for (int i : arr[t]) {
                if (!visited[i]) {
                    visited[i] = true;
                    ans[i]++;
                    q.add(i);
                }
            }
        }
    }
}
