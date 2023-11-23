import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        long[] c = new long[M];
        st = new StringTokenizer(br.readLine());

        long ans = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = (arr[i - 1] + Long.parseLong(st.nextToken())) % M;
            if (arr[i] == 0) {
                ans++;
            }
            c[(int) arr[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (c[i] > 1) {
                ans += (c[i] * (c[i] - 1)) / 2;
            }
        }

        System.out.println(ans);
    }
}
