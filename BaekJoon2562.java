import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 1; i < 10; i++) {
            int t = Integer.parseInt(br.readLine());
            if (t > ans1) {
                ans1 = t;
                ans2 = i;
            }
        }
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
