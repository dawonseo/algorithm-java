import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1182 {

    static int N, S;
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        if (S == 0) ans--;

        System.out.println(ans);
    }

    private static void DFS(int sum, int idx) {
        if (idx == N) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        DFS(sum + arr[idx], idx + 1);
        DFS(sum, idx + 1);
    }
}
