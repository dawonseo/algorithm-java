import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        while (K > 0) {
            int i = Integer.parseInt(br.readLine());
            if (i == 0 && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(i);
            }
            K--;
        }

        int sum = 0;

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);

    }
}
