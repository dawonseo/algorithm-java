import java.io.IOException;
import java.util.HashMap;

public class BaekJoon1157 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

        int str;
        int c = 0;
        int answer = 0;

        while(true) {
            str = System.in.read();

            if(str == 10) {
                break;
            }

            if (97 <= str && str <= 122) {
                str -= 32;
            }

            if (!counts.containsKey(str)) {
                counts.put(str, 1);
            } else {
                counts.put(str, counts.get(str) + 1);
            }

            if (counts.get(str) > c) {
                answer = str;
                c = counts.get(str);
            } else if (counts.get(str) == c) {
                answer = 63;
            }
        }

        System.out.println((char)answer);
    }
}
