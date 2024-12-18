import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2805 {

    private static long[] trees;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new long[N];

        st = new StringTokenizer(br.readLine());
        long right = 0;
        long left = 0;

        for (int i = 0; i < N; i++) {
            long cur = Long.parseLong(st.nextToken());
            trees[i] = cur;
            if (cur > right) right = cur;
        }

        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long collectedAmount = getCollectedAmount(mid);

            if (collectedAmount >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static long getCollectedAmount(long amount) {
        long ret = 0;

        for (long tree : trees) {
            if (tree > amount) {
                ret += tree - amount;
            }
        }

        return ret;
    }
}
