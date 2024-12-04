import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11720_stream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int ans = br.readLine().chars().map(c -> c - '0').sum();

        System.out.println(ans);
    }
}
