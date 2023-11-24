import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int cnt = 0;
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
           int startIndex = 0;
           int endIndex = N - 1;
           long M = arr[i];

           while(startIndex < endIndex) {
               long t = arr[startIndex] + arr[endIndex];

               if (t == M) {
                   if (startIndex != i && endIndex != i) {
                       cnt++;
                       break;
                   } else if (startIndex == i) {
                       startIndex++;
                   } else if (endIndex == i) {
                       endIndex--;
                   }
               } else if (t < M) {
                   startIndex++;
               } else {
                   endIndex--;
               }
           }
        }

        System.out.println(cnt);
    }
}
