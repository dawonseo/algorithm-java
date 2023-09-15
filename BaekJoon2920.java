import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = st.countTokens();
        int i = 0;
        int pre = Integer.parseInt(st.nextToken());
        Boolean flag = null;

        while (i < (N - 1)) {
            int t = Integer.parseInt(st.nextToken());
            if (pre + 1 == t) {
                if (Boolean.FALSE.equals(flag)) {
                    System.out.println("mixed");
                    System.exit(0);
                } else {
                    flag = Boolean.TRUE;
                }
            } else if (pre - 1 == t) {
                if (Boolean.TRUE.equals(flag)) {
                    System.out.println("mixed");
                    System.exit(0);
                } else {
                    flag = Boolean.FALSE;
                }
            } else {
                System.out.println("mixed");
                System.exit(0);
            };
            pre = t;
            i++;
        }

        if (Boolean.TRUE.equals(flag)) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}
