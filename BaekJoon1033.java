import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1033 {
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static long lcm = 1;
    static long[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ans = new long[N];
        arr = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Node>();
        }

        StringTokenizer st;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));

            lcm *= (p * q / findGCD(p, q));
        }
        ans[0] = lcm;
        DFS(0);
        long mgcd = ans[0];

        for (int i = 1; i < N; i++) {
            mgcd = findGCD(mgcd, ans[i]);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] / mgcd + " ");
        }
    }

    static long findGCD(long a, long b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

    static long findLCM(long a, long b) {
        return a * b / findGCD(a, b);
    }

    static void DFS(int edge) {
        visited[edge] = true;
        for (int i = 0; i < arr[edge].size(); i++) {
            int next = arr[edge].get(i).connectedNode;
            if (!visited[next]) {
                ans[next] = ans[edge] * arr[edge].get(i).q / arr[edge].get(i).p;
                DFS(next);
            }
        }
    }

    static class Node {
        int connectedNode;
        int p;
        int q;

        Node(int connectedNode, int p, int q) {
            this.connectedNode = connectedNode;
            this.p = p;
            this.q = q;
        }
    }
}
