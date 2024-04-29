import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BaekJoon1850 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        long A = scanner.nextLong();
        long B = scanner.nextLong();

        long ansCnt = checkGCD(A, B);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (long i = 0; i < ansCnt; i++) {
            bw.append("1");
        }

        bw.flush();
        bw.close();
    }

    static long checkGCD(long A, long B) {
        if (A % B == 0) return B;
        return checkGCD(B, A % B);
    }
}
