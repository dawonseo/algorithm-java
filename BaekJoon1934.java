import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int gcd = 0;

            if (A >= B) {
                gcd = findGCD(A, B);
            } else {
                gcd = findGCD(B, A);
            }

            System.out.println(A * B / gcd);

        }
    }

    static int findGCD(int a, int b) {
        if (a % b == 0) return b;
        return findGCD(b, a % b);
    }
}
