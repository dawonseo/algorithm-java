import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) break;
            String ans = "yes";

            char[] nums = num.toCharArray();

            int n = nums.length;
            for (int i = 0; i < n / 2; i++) {
                if (nums[i] != nums[n - (i + 1)]) {
                    ans = "no";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
