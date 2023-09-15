import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon3052 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Boolean> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int t = Integer.parseInt(br.readLine());
            if (map.containsKey(t % 42)) {
                continue;
            } else {
                map.put(t % 42, Boolean.TRUE);
            }
        }
        System.out.println(map.size());
    }
}
