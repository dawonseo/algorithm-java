import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1197 {
    static int[] parent;
    static PriorityQueue<pEdge> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            queue.add(new pEdge(s, e, v));
        }

        int useEdge = 0;
        int ans = 0;

        while (useEdge < V - 1) {
            pEdge cur = queue.poll();

            if (find(cur.s) != find(cur.e)) {
                ans += cur.v;
                useEdge++;
                union(cur.s, cur.e);
            }
        }

        System.out.println(ans);

    }

    private static int find(int num) {
        if (parent[num] == num) {
            return num;
        } else {
            return parent[num] = find(parent[num]);
        }
    }

    private static void union(int num1, int num2) {
        int a = find(num1);
        int b = find(num2);

        if (a != b) {
            parent[b] = a;
        }
    }

    static class pEdge implements Comparable<pEdge> {
        int s;
        int e;
        int v;

        pEdge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(pEdge o) {
            return this.v - o.v;
        }
    }
}
