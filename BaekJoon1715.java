import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BaekJoon1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        int n1 = 0;
        int n2 = 0;

        while (q.size() > 1) {
            n1 = q.remove();
            n2 = q.remove();
            ans += n1 + n2;
            q.add(n1 + n2);
        }

        System.out.println(ans);
    }
}
