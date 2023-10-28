import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String t = st.nextToken();

            switch (t) {
                case "push_front":
                    deque.addFirst(st.nextToken());
                    break;
                case "push_back":
                    deque.addLast(st.nextToken());
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.removeFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.removeLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.getFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.getLast()).append("\n");
                    }
                    break;
            }
            N--;
        }

        System.out.println(sb.toString());
    }
}
