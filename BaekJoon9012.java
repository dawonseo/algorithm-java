import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int vps;

        StringBuilder sb = new StringBuilder();

        w : while (N > 0) {
            char[] arr = br.readLine().toCharArray();
            vps = 0;
            for (char c : arr) {
                if (c == '(') {
                    vps++;
                } else {
                    vps--;
                }
                if (vps < 0) {
                    sb.append("NO").append("\n");
                    N--;
                    continue w;
                }
            }

            if (vps != 0) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
            N--;
        }

        System.out.println(sb.toString());
    }
}
