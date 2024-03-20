import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BaekJoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] >= num) {
                while (arr[i] > num) {
                    stack.add(num++);
                    sb.append("+\n");
                }
                sb.append("+\n");
                sb.append("-\n");
                num++;
            } else {
                if (stack.peek() == arr[i]) {
                    sb.append("-\n");
                    stack.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
