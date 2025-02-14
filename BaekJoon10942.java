import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon10942 {
    static int N, M;
    static int[] nums;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nums = new int[N + 1];
        dp = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
            if (i != N && nums[i] == nums[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for(int i = 2; i < N; i++){
            for(int j = 1; j <= N - i; j++){
                if(nums[j] == nums[j + i] && dp[j + 1][j + i - 1] == 1)
                    dp[j][j + i] = 1;
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(dp[S][E]).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
