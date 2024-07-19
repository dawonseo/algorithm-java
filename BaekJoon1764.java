import java.io.*;
import java.util.*;

public class BaekJoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<String>();
        ArrayList<String> ansArr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String name = "";

        for (int i = 0; i < N; i++) {
            name = br.readLine();
            set.add(name);
        }

        for (int i = 0; i < M; i++) {
            name = br.readLine();
            if (set.contains(name)) ansArr.add(name);
        }

        Collections.sort(ansArr);

        StringBuilder sb = new StringBuilder();
        sb.append(ansArr.size()).append("\n");
        for (int i = 0; i < ansArr.size(); i++) {
            sb.append(ansArr.get(i)).append("\n");
        }

        System.out.println(sb);

    }
}
