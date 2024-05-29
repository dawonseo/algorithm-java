import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1043 {
    static int[] parent;
    static int[] trueP;
    static ArrayList<Integer>[] party;
    static int result;
    public static void main(String[] args) throws IOException {
        // N: 사람의 수, M: 파티의 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        trueP = new int[T];

        for (int i = 0; i < T; i++) {
            trueP[i] = Integer.parseInt(st.nextToken());
        }
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {   // 대표 노드를 자기 자신으로 초기화
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int firstPeople = party[i].get(0);
            for (int j = 0; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        // 각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음
        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for (int j = 0; j < trueP.length; j++) {
                if (find(cur) == find(trueP[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) result++;
        }

        System.out.println(result);
    }

    public static void union(int num1, int num2) {
        num1 = find(num1);
        num2 = find(num2);

        if (num1 != num2) {
            parent[num2] = num1;
        }
    }

    public static int find(int num) {
        if (num == parent[num]) {
            return num;
        } else {
            return parent[num] = find(parent[num]);
        }
    }

    public static boolean checkSame(int num1, int num2) {
        num1 = find(num1);
        num2 = find(num2);
        if (num1 == num2) {
            return true;
        }
        return false;
    }
}
