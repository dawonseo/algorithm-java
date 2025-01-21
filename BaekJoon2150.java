import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon2150 {

    static int V, E, id;
    static boolean[] finished;
    static int[] ids, low;
    static ArrayList<Integer>[] arr;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> sccList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 수
        V = Integer.parseInt(st.nextToken());
        // 간선의 수
        E = Integer.parseInt(st.nextToken());

        finished = new boolean[V + 1];
        ids = new int[V + 1];
        low = new int[V + 1];
        arr = new ArrayList[V + 1];
        id = 0;

        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A].add(B);
        }

        for (int i = 1; i <= V; i++) {
            if (ids[i] == 0) {
                DFS(i);
            }
        }

        for (ArrayList<Integer> scc : sccList) {
            scc.sort(null);
        }
        sccList.sort((o1, o2) -> o1.get(0) - o2.get(0));

        StringBuilder sb = new StringBuilder();
        sb.append(sccList.size()).append("\n");
        for (ArrayList<Integer> scc : sccList) {
            for (int node : scc) {
                sb.append(node).append(" ");
            }
            sb.append("-1\n");
        }

        System.out.print(sb);
    }

    private static void DFS(int at) {
        // id와 low-link 값을 초기화한다
        ids[at] = low[at] = ++id;
        stack.push(at);

        for (int to : arr[at]) {
            // 방문하지 않은 정점
            if (ids[to] == 0) {
                DFS(to);
                low[at] = Math.min(low[at], low[to]);
            } else if (!finished[to]) { // 방문했고, 스택에 있음
                low[at] = Math.min(low[at], low[to]);
            }
        }

        // 루트임을 확인
        if (ids[at] == low[at]) {
            ArrayList<Integer> scc = new ArrayList<>();

            // 자기자신이 나올 때까지 pop하여 scc에 추가
            // pop한 노드는 완료처리
            while (true) {
                int node = stack.pop();
                finished[node] = true;
                scc.add(node);
                if (node == at) break;
            }

            sccList.add(scc);
        }
    }
}
