import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1966_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Job> printWorkQueue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                int t = Integer.parseInt(st.nextToken());
                pq.offer(t);
                printWorkQueue.offer(new Job(t, i));
            }

            int ans = 0;

            while (printWorkQueue.size() > 0) {
                Job cur = printWorkQueue.poll();

                if (cur.getPriority() == pq.peek()) {
                    ans++;
                    pq.poll();
                    if (cur.getIndex() == M) {
                        System.out.println(ans);
                        break;
                    }
                } else {
                    printWorkQueue.offer(cur);
                }
            }
        }

    }

    static class Job {
        private int priority;
        private int index;

        public Job(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }

        public int getPriority() {
            return priority;
        }

        public int getIndex() {
            return index;
        }
    }
}
