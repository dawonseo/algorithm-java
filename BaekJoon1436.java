import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int i = 0;
        int j = 0;
        String ans = "";

        while (true) {
            if (String.valueOf(j).contains("666")) {
                i++;
            }
            if (i == N) {
                ans = String.valueOf(j);
                break;
            }
            j++;
        }

        System.out.println(ans);
    }
}
