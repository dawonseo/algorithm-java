import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1916 {
    public static int[] distance;
    public static boolean[] visited;
    public static ArrayList<Edge>[] list;
    public static PriorityQueue<Edge> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        // 버스 개수 M 입력
        int M = Integer.parseInt(br.readLine());
        // 도시 번호는 1부터 N까지
        // A에서 B까지 가는 버스 비용을 최소화한다
        // 출발, 도착, 비용 순으로 주어진다
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Edge>();
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, v));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        distance[A] = 0;

        q.offer(new Edge(A, 0));

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            int now = cur.num;
            if (!visited[now]) {
                visited[now] = true;
                for (Edge next : list[now]) {
                    if (!visited[next.num] && (distance[next.num] > distance[now] + next.val)) {
                        distance[next.num] = distance[now] + next.val;
                        q.add(new Edge(next.num, distance[next.num]));
                    }
                }
            }
        }

        System.out.println(distance[B]);
    }

    public static class Edge implements Comparable<Edge> {
        int num;
        int val;

        Edge(int num, int val) {
            this.num = num;
            this.val = val;
        }

        @Override
        public int compareTo(Edge e) {
            return val - e.val;
        }
    }
}
