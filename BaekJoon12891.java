import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon12891 {
    public static void main(String[] args) throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        int ACnt = Integer.parseInt(st.nextToken());
        int CCnt = Integer.parseInt(st.nextToken());
        int GCnt = Integer.parseInt(st.nextToken());
        int TCnt = Integer.parseInt(st.nextToken());

        for (int i = 0; i < P; i++) {
            switch (arr[i]) {
                case 'A':
                    ACnt--;
                    break;
                case 'C':
                    CCnt--;
                    break;
                case 'G':
                    GCnt--;
                    break;
                case 'T':
                    TCnt--;
                    break;
            }
        }

        if (ACnt <= 0 && CCnt <= 0 && GCnt <= 0 && TCnt <= 0) ans++;

        for (int i = 0; i < (S - P); i++) {
            switch (arr[i]) {
                case 'A':
                    ACnt++;
                    break;
                case 'C':
                    CCnt++;
                    break;
                case 'G':
                    GCnt++;
                    break;
                case 'T':
                    TCnt++;
                    break;
            }
            switch (arr[i + P]) {
                case 'A':
                    ACnt--;
                    break;
                case 'C':
                    CCnt--;
                    break;
                case 'G':
                    GCnt--;
                    break;
                case 'T':
                    TCnt--;
                    break;
            }
            if (ACnt <= 0 && CCnt <= 0 && GCnt <= 0 && TCnt <= 0) ans++;
        }

        System.out.println(ans);
    }
}
