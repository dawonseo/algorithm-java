import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BaekJoon2023 {
    static ArrayList<Integer> ansArr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        DFS(0, N);

        Collections.sort(ansArr);

        for (int i = 0; i < ansArr.size(); i++) {
            System.out.println(ansArr.get(i));
        }
    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2 ; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void DFS(int num, int N) {
        for(int i = 1; i < 10; i++) {
            int n = num + i;
            if (isPrime(n)) {
                if (N == 1) {
                    ansArr.add(n);
                } else {
                    DFS(n * 10, N - 1);
                }
            }
        }
    }
}
