import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int startIndex = 0;
        int endIndex = N - 1;
        long t = 0;
        long cnt = 0;
        if (t == M) {
            cnt++;
        }

        while (endIndex > startIndex) {
            t = arr[endIndex] + arr[startIndex];
            if (t == M) {
                cnt++;
                startIndex++;
                endIndex--;
            } else if (t > M) {
                endIndex--;
            } else {
                startIndex++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
