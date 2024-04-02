import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1517 {
    public static int[] arr, tmp;
    public static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        mergeSort(1, N);

        System.out.println(ans);
    }

    private static void mergeSort(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(l, m);
            mergeSort(m + 1, r);

            merge(l, r, m);
        }
    }

    private static void merge(int l, int r, int m) {
        for (int i = l; i <= r; i++) {
            tmp[i] = arr[i];
        }
        int k = l;
        int index1 = l;
        int index2 = m + 1;
        while (index1 <= m && index2 <= r) {
            if (tmp[index1] > tmp[index2]) {
                arr[k] = tmp[index2];
                ans = ans + index2 - k;
                k++;
                index2++;
            } else {
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= r) {
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
