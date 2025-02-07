import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1629 {
    static long A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    private static long pow(long a, long b) {
        if (b == 0) return 1;
        if (b == 1) return a % C;

        long tmp = pow(a, (b / 2)) % C;

        if (b % 2 == 1) {
            return ((tmp * tmp % C) * (a % C)) % C;
        }

        return tmp * tmp % C;
    }
}
