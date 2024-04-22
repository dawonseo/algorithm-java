import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BaekJoon1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

        }

        long ans = 0;
        int t = 0;

        while (!maxHeap.isEmpty()) {
            t = maxHeap.poll();
            if (t != 1) {
                if (!maxHeap.isEmpty() && maxHeap.peek() > 1) {
                    t *= maxHeap.poll();
                }
            }
            ans += t;
        }

        while (!minHeap.isEmpty()) {
            t = minHeap.poll();
            if (!minHeap.isEmpty()) {
                t *= minHeap.poll();
            }
            ans += t;
        }

        System.out.println(ans);
    }
}

