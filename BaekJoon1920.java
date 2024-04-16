import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1920 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr2 = new int[M];


        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            binarySearch(arr2[i]);
        }
    }

    static void binarySearch(int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int m = (left + right) / 2;
            if (arr[m] > num) {
                right = m - 1;
            } else if (arr[m] < num) {
                left = m + 1;
            } else {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}