import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon13023 {
    private static ArrayList<Integer>[] friendMap;
    private static boolean[] visited;
    private static boolean answer = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        friendMap = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            friendMap[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            friendMap[s].add(e);
            friendMap[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
        }

        if (answer) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void DFS(int now, int depth) {
        if (depth == 5 || answer) {
            answer = true;
            return;
        }

        visited[now] = true;

        for (int i : friendMap[now]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}
