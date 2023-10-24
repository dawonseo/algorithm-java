import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        ArrayList<Integer> answers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = (br.readLine()).toCharArray();
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int result1 = 0;
                int result2 = 0;
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        if ((x + y) % 2 == 0) {
                            if (arr[x][y] == 'W') {
                                result1++;
                            } else {
                                result2++;
                            }
                        } else {
                            if (arr[x][y] == 'W') {
                                result2++;
                            } else {
                                result1++;
                            }
                        }
                    }
                }
                answers.add(result1);
                answers.add(result2);
            }
        }
        System.out.println(Collections.min(answers));
    }
}
