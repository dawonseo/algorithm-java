import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1167 {
    static ArrayList<int[]>[] arr;
    static boolean[] visited;
    static int node;
    static int maxValue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            arr[t] = new ArrayList<int[]>();

            while (st.hasMoreTokens()) {
                int k = Integer.parseInt(st.nextToken());

                if (k == -1) {
                    break;
                }

                int v = Integer.parseInt(st.nextToken());

                arr[t].add(new int[]{k, v});
            }
        }

        DFS(1, 0);
        maxValue = 0;
        visited = new boolean[N + 1];
        DFS(node, maxValue);
        System.out.println(maxValue);

    }

    static void DFS(int n, int cnt) {
        visited[n] = true;

        if (cnt > maxValue) {
            node = n;
            maxValue = cnt;
        }

        for (int[] num : arr[n]) {
            if (!visited[num[0]]) {
                DFS(num[0], cnt + num[1]);
            }
        }
    }
}
