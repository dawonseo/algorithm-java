import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BaekJoon1874_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int pointer = 0;

        for (int i = 1; i <= n; i++) {
            stack.add(i);
            sb.append("+\n");

            while (!stack.isEmpty() && stack.peekLast() == arr[pointer]) {
                stack.pollLast();
                sb.append("-\n");
                pointer++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
