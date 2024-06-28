import java.util.Scanner;

public class BaekJoon1463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] m = new int[N+ 1];
        m[1] = 0;

        for (int i = 2; i <= N; i++) {
            m[i] = m[i - 1] + 1;
            if (i % 2 == 0) m[i] = Math.min(m[i], m[i / 2] + 1);
            if (i % 3 == 0) m[i] = Math.min(m[i], m[i / 3] + 1);
        }

        System.out.println(m[N]);
    }
}
