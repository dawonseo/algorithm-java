import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        m -= 45;
        StringBuilder sb = new StringBuilder();
        if (m < 0) {
            if (H == 0) {
                sb.append(23).append(" ");
            } else {
                sb.append(H - 1).append(" ");
            }
            sb.append(m + 60);
        } else {
            sb.append(H).append(" ").append(m);
        }

        System.out.println(sb);
    }
}
