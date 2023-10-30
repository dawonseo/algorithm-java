import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BaekJoon1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger fac = new BigInteger("1");

        for (int i = 1; i <= N; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }

        int ans = 0;

        String strFac = String.valueOf(fac);

        for (int i =  strFac.length() - 1; i >= 0; i--) {
            if (strFac.charAt(i) == '0') {
                ans += 1;
            } else {
                break;
            }
        }

        System.out.println(ans);
    }
}
