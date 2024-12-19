import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon15649 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DFS(new StringBuilder(), new boolean[N + 1], 0);
    }

    public static void DFS(StringBuilder sb, boolean[] visited, int cnt) {
        if (cnt == M) {
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                sb.append(i).append(" ");
                visited[i] = true;
                DFS(sb, visited, cnt + 1);
                visited[i] = false;
                sb.setLength(sb.length() - 2);
            }
        }
    }
}
