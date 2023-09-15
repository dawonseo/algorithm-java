import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String t = br.readLine();
            int p = 0;
            int np = 0;
            char pre = 'S';
            for (int j = 0; j < t.length(); j++) {
                if (t.charAt(j) == 'O') {
                    if (pre != 'O') {
                        np = 0;
                    }
                    p += ++np;
                }
                pre = t.charAt(j);
            }
            sb.append(p).append("\n");
        }
        System.out.println(sb);
    }
}
