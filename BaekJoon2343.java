import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2343 {
    static int[] arr;
    static int left = 0;
    static int right = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > left) left = arr[i];
            right += arr[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if ((sum + arr[i]) > mid) {
                    cnt += 1;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (sum != 0) {
                cnt += 1;
            }

            if (cnt > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(left);
    }
}
