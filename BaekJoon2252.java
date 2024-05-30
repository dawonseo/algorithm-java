import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 학생 수
        int N = Integer.parseInt(st.nextToken());
        // 키를 비교한 횟수
        int M = Integer.parseInt(st.nextToken());
        // 진입 차수를 저장하는 배열
        int[] inArr = new int[N + 1];
        // 인접 리스트
        ArrayList<Integer>[] arr = new ArrayList[N + 1];

        ArrayList<Integer> ans = new ArrayList<>();


        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A].add(B);
            inArr[B]++;
        }

        int cnt = 0;

        while (true) {
            for (int i = 1; i <= N; i++) {
                if (inArr[i] == 0) {
                    ans.add(i);
                    cnt++;
                    inArr[i]--;
                    for (int j = 0; j < arr[i].size(); j++) {
                        inArr[arr[i].get(j)]--;
                    }
                }
            }
            if (cnt == N) {
                break;
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
