import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long startIndex = 1;
        long endIndex = 1;
        long ans = 1;
        long t = 1;

        while (endIndex != N) {
            if (t == N) {
                ans++;
                endIndex++;
                t+=endIndex;
            } else if(t > N) {
                t-=startIndex;
                startIndex++;
            } else {
                endIndex++;
                t+=endIndex;
            }
        }

        System.out.println(ans);
    }
}
