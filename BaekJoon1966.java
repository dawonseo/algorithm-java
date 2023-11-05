import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class P {
    int num;
    int order;

    public int getNum() {
        return num;
    }

    public int getOrder() {
        return order;
    }

    public P(int num, int order) {
        this.num = num;
        this.order = order;
    }
}

public class BaekJoon1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        w: while (K > 0) {
            Queue<P> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[N];

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int thisT = Integer.parseInt(st2.nextToken());
                arr[i] = thisT;
                q.add(new P(thisT, i));
            }

            Arrays.sort(arr, Collections.reverseOrder());

            int j = 0;
            int ans = 1;
            while (!q.isEmpty()) {
                P thisP = q.poll();

                if (thisP.getNum() == arr[j]) {
                    if (thisP.getOrder() == M) {
                        sb.append(ans).append("\n");
                        K--;
                        continue w;
                    } else {
                        ans++;
                        j++;
                    }
                } else {
                    q.add(thisP);
                }
            }
            K--;
        }

        System.out.println(sb.toString());

    }
}
