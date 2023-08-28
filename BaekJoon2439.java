import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < (N + 1); i++) {
            sb.append(" ".repeat(N - i));
            sb.append("*".repeat(i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
