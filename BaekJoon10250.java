import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.*;

public class BaekJoon10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int temp1 = N % H;
            int temp2 = (int)Math.ceil((double)N / H);

            if (temp1 == 0) temp1 = H;

            sb.append(String.format("%d%02d", temp1, temp2));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
