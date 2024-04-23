import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1929 {
    static boolean[] primeNums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        primeNums = new boolean[N + 1];
        Arrays.fill(primeNums, true);
        checkPrimeNums();

        for (int i = M; i < N + 1; i++) {
            if (primeNums[i]) {
                System.out.println(i);
            }
        }
    }

    public static void checkPrimeNums() {
        primeNums[0] = primeNums[1] = false;
        for (int i = 2; i < Math.sqrt(primeNums.length); i++) {
            if (!primeNums[i]) {
                continue;
            }
            for (int j = 2; j * i < primeNums.length; j++) {
                primeNums[j * i] = false;
            }
        }
    }
}
