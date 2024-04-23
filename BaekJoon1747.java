import java.util.Scanner;

public class BaekJoon1747 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long ans = N;

        while (true) {
            if (ans == 1) {
                ans++;
                continue;
            }
            if (isPalindrome(ans) && !isPrime(ans)) {
                System.out.println(ans);
                return;
            }
            ans++;
        }
    }

    static boolean isPalindrome(long num) {
        char[] temp = String.valueOf(num).toCharArray();
        for (int i = 0; i < temp.length / 2; i++) {
            if (temp[i] != temp[temp.length - 1 - i]) return false;
        }
        return true;
    }

    static boolean isPrime(long num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            for (int j = i * 2; j <= num; j += i) {
                if (j == num) return true;
            }
        }
        return false;
    }
}
