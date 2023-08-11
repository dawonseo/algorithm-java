import java.io.IOException;

public class BaekJoon1152Another {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int pre_str = 32;
        int str;

        while(true) {
            str = System.in.read();

            if(str == 32) {
                if(pre_str != 32) count++;
            }

            else if(str == 10) {
                if(pre_str != 32) count++;
                break;
            }

            pre_str = str;
        }

        System.out.println(count);
    }
}
