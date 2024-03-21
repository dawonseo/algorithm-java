import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int m = 0;

        for (int i = 0; i < N; i++) {
            int t = arr[i].index - i;
            if (t > m) {
                m = t;
            }
        }
        System.out.println(m + 1);
    }

    static class Node implements Comparable<Node> {
        int num;
        int index;

        Node(int num, int index) {
            super();
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }
}
