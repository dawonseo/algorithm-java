import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        arr[0] = 0;

        for (int i = 1; i < N + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st3.nextToken());
            int y = Integer.parseInt(st3.nextToken());

            sb.append(arr[y] - arr[x - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
