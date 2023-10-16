import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2609 {
    public static int getGcd(int num1, int num2) {
        return num2 != 0 ? getGcd(num2, num1 % num2) : num1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());

        int gcd = getGcd(i, j);

        System.out.println(gcd);
        System.out.println((i * j) / gcd);
    }
}
