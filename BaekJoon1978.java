import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1978 {
    public static boolean isPrime(int num) {

        if (num == 1) {
            return false;
        }

        boolean flag = true;
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            if (isPrime(Integer.parseInt(st.nextToken()))) {
                ans++;
            };
        }

        System.out.println(ans);
    }
}
