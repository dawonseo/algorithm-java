import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        ArrayList<String> ans = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (i == (K - 1)) {
                    ans.add(String.valueOf(q.remove()));
                } else {
                    q.add(q.remove());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        sb.append(String.join(", ", ans));
        sb.append(">");

        System.out.println(sb.toString());
    }
}
