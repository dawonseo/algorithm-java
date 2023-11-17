import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        double maxScore = Arrays.stream(arr).max().getAsDouble();
        double sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] / maxScore * 100;
            sum += arr[i];
        }

        System.out.println(sum / N);

    }
}
