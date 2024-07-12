import java.io.*;
import java.util.PriorityQueue;

public class BaekJoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            if (first == second) return o1 - o2;
            else return first - second;
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(tmp);
            }
        }

        bw.flush();
        bw.close();
    }
}
