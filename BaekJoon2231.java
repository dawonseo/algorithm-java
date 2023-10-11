import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 1; i < N; i++) {
            int ii = i;
            int j = 10;
            int k = 0;
            int tmp = i;
            while (j < i * 10) {
                k = (ii % j) / (j / 10);
                tmp += k;
                j *= 10;
                ii -= k;
            }

            if (tmp == N) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
