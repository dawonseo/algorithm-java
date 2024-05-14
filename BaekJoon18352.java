import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon18352 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int K;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(X, 0));
        visited[0] = visited[X] = true;

        while (!q.isEmpty()) {
            Node t = q.poll();
            if (t.d == K) {
                ans.add(t.V);
            }

            for (int i = 0; i < arr[t.V].size(); i++) {
                int tmp = arr[t.V].get(i);
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    q.add(new Node(tmp, t.d + 1));
                }
            }
        }
        if (!ans.isEmpty()) {
            for (int i = 0; i < ans.size(); i++) {
                Collections.sort(ans);
                System.out.println(ans.get(i));
            }
        } else {
            System.out.println(-1);
        }
    }

    static class Node {
        private int V;
        private int d;

        Node(int V, int d) {
            this.V = V;
            this.d = d;
        }
    }
}