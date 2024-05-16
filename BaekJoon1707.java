import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1707 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] grouped;
    static boolean ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            grouped = new int[V + 1];
            ans = true;

            for (int k = 1; k <= V; k++) {
                graph[k] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            for (int j = 1; j <= V; j++) {
                if (!visited[j]) {
                    if (ans) {
                        BFS(j);
                    } else {
                        break;
                    }
                }
            }

            if (ans) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void BFS(int startNode) {
        Queue<Integer> q = new LinkedList<>();

        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int t = q.poll();

            for (int i : graph[t]) {
                if (visited[i]) {
                    if (grouped[i] == grouped[t]) {
                        ans = false;
                        return;
                    }
                } else {
                    visited[i] = true;
                    grouped[i] = 1 - grouped[t];
                    q.add(i);
                }
            }
        }
    }
}
