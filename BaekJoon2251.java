import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2251 {
    static ArrayList<Integer> ans = new ArrayList<>();
    static boolean[][][] visited;
    static int A, B, C;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();

        visited = new boolean[A + 1][B + 1][C + 1];
        DFS(0, 0, C);

        ans.sort((o1, o2) -> o1 - o2);

        StringBuilder sb = new StringBuilder();

        for (int a : ans) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }

    static void DFS(int a, int b, int c) {
        if (visited[a][b][c]) return;
        if (a == 0) {
            ans.add(c);
        }
        visited[a][b][c] = true;

        if (a != 0) {
            int tmp1 = Math.min(a, B - b);
            DFS(a - tmp1, b + tmp1, c);
            int tmp2 = Math.min(a, C - c);
            DFS(a - tmp2, b, c + tmp2);
        }

        if (b != 0) {
            int tmp1 = Math.min(b, A - a);
            DFS(a + tmp1, b - tmp1, c);
            int tmp2 = Math.min(b, C - c);
            DFS(a, b - tmp2, c + tmp2);
        }

        if (c != 0) {
            int tmp1 = Math.min(c, A - a);
            DFS(a + tmp1, b, c - tmp1);
            int tmp2 = Math.min(c, B - b);
            DFS(a, b + tmp2, c - tmp2);
        }
    }
}
