import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon1717 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 0부터 n까지 배열 생성
        arr = new int[n + 1];

        // 인덱스 값으로 초기화
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        // m만큼 반복
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 0) {
                // 0으로 시작하면, a와 b를 합친다.
                union(a, b);
            } else {
                // 1으로 시작하면, a와 b가 같은 집합에 포함되어 있는지를 확인한다.
                if (find(a) == find(b)) {
                    bw.append("YES");
                } else {
                    bw.append("NO");
                }

                bw.append("\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static int find(int num) {
        if (arr[num] == num) {
            return num;
        } else {
            return arr[num] = find(arr[num]);
        }
    }

    private static void union(int num1, int num2) {
        int a = find(num1);
        int b = find(num2);

        if (a != b) {
            arr[b] = a;
        }
    }
}
