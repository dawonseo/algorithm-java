import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 자기보다 빨리 지어져야 하는 건물 번호 저장
        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        // 진입 차수 저장
        int[] inArr = new int[N + 1];
        int[] ans = new int[N + 1];
        int[] buildTime = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 짓는데 걸리는 시간
            int t = Integer.parseInt(st.nextToken());
            buildTime[i] = t;

            while (true) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == -1) break;

                inArr[i]++;
                arr[tmp].add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inArr[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int th = queue.poll();
            for (int num : arr[th]) {
                inArr[num]--;
                ans[num] = Math.max(ans[num], ans[th] + buildTime[th]);
                if (inArr[num] == 0) {
                    queue.offer(num);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(ans[i] + buildTime[i]);
        }
    }
}
