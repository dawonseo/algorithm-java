import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        int ans = 0;

        String[] S = st.nextToken().split(":");
        int startTime = Integer.parseInt(S[0]) * 60 + Integer.parseInt(S[1]);
        String[] E = st.nextToken().split(":");
        int endTime = Integer.parseInt(E[0]) * 60 + Integer.parseInt(E[1]);
        String[] Q = st.nextToken().split(":");
        int quitTime = Integer.parseInt(Q[0]) * 60 + Integer.parseInt(Q[1]);

        String input = "";
        while ((input = br.readLine()) != null && (input.length() > 0)) {
            st = new StringTokenizer(input);

            String[] t = st.nextToken().split(":");
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            String n = st.nextToken();

            if (time <= startTime) {
                set.add(n);
            } else if (endTime <= time && time <= quitTime) {
                if (set.contains(n)) {
                    set.remove(n);
                    ans++;
                }
            }
        }

        System.out.println(ans);


    }
}
