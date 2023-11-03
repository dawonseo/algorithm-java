import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int per = (int)Math.round(n * 0.15);
        int ans = 0;

        for(int i = per; i < n - per; i++) {
            ans += arr[i];
        }

        ans = (int) Math.round((double) ans / (n - (per * 2)));

        System.out.println(ans);
    }
}
