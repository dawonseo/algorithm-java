import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1976 {
    static ArrayList<Integer>[] arr;
    static int[] unionArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new ArrayList[N + 1];
        unionArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            unionArr[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();

            // N개의 번호 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int t = Integer.parseInt(st.nextToken());

                if (i == j) continue;

                if (t == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력 받기
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        String ans = "YES";

        // union find를 통해 답 출력
        int tmp = Integer.parseInt(st2.nextToken());
        for (int i = 0; i < M - 1; i++) {
            int tmp2 = Integer.parseInt(st2.nextToken());

            if (find(tmp) == find(tmp2)) {
                tmp = tmp2;
            } else {
                ans = "NO";
                break;
            }
        }

        System.out.println(ans);
    }

    static void union(int num1, int num2) {
        int a = find(num1);
        int b = find(num2);

        if (a != b) {
            unionArr[b] = a;
        }
    }

    static int find(int num) {
        if (unionArr[num] == num) {
            return num;
        } else {
            return unionArr[num] = find(unionArr[num]);
        }
    }
}
