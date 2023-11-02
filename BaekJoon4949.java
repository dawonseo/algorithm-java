import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        a : while (true) {

            String t = br.readLine();

            if (t.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();

            char[] arr = t.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];

                if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        sb.append("no").append("\n");
                        continue a;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        sb.append("no").append("\n");
                        continue a;
                    }
                } else if (c == '(' || c == '[') {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}
