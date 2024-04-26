import java.util.Scanner;

public class BaekJoon11689 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long ans = n;

        for (int p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {
                ans = ans - ans / p;
                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            ans = ans - ans / n;
        }

        System.out.println(ans);
    }

}
