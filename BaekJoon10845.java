import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<String> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        String last = "";

        while (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String t = st.nextToken();

            if (t.equals("push")) {
                last = st.nextToken();
                queue.add(last);
            } else if (t.equals("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if (t.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (t.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (t.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if (t.equals("back")) {
                if (!queue.isEmpty()) {
                    sb.append(last).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            }
            N--;
        }

        System.out.println(sb.toString());
    }
}
