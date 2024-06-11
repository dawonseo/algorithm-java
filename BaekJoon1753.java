import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1753 {
    // 인접 리스트
    static ArrayList<Node>[] arr;
    // 최단거리 배열
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        arr = new ArrayList[V + 1];
        d = new int[V + 1];

        int K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[u].add(new Node(v, w));
        }

        // 우선순위 큐 사용
        PriorityQueue<Node> queue = new PriorityQueue<Node>(((o1, o2) -> Integer.compare(o1.w, o2.w)));
        queue.offer(new Node(K, 0));

        for (int i = 1; i <= V; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[K] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 비용이 현재 저장된 최소 비용보다 크다면, 고려할 필요 없다
            if (d[now.v] < now.w) continue;

            for (Node next: arr[now.v]) {
                if (d[next.v] > now.w + next.w) {
                    d[next.v] = now.w + next.w;
                    queue.offer(new Node(next.v, now.w + next.w));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (d[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }
    }

    static class Node {
        int v;
        int w;

        Node (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
