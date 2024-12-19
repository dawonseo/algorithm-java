import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon15650 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DFS(new StringBuilder(), 1, 0);
    }

    public static void DFS(StringBuilder sb, int num, int cnt) {
        if (cnt == M) {
            System.out.println(sb);
            return;
        }

        for (int i = num; i <= N; i++) {
            sb.append(i).append(" ");
            DFS(sb, i + 1, cnt + 1);
            sb.setLength(sb.length() - 2);
        }
    }
}
