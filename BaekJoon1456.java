import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1456 {
    static boolean[] primeNums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long A = scanner.nextLong();
        long B = scanner.nextLong();


        primeNums = new boolean[(int) Math.sqrt(B) + 1];
        Arrays.fill(primeNums, true);
        checkPrime();

        int ans = 0;

        for (long i = 2; i < primeNums.length; i++) {
            if (primeNums[(int) i]) {
                for (double j = i ; j <= (double)B / (double)i; j *= i) {
                    if (j >= (double)A / (double)i) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void checkPrime() {
        primeNums[0] = primeNums[1] = false;

        for (int i = 2; i < primeNums.length; i++) {
            for (int j = 2 * i; j < primeNums.length; j += i) {
                primeNums[j] = false;
            }
        }
    }
}
