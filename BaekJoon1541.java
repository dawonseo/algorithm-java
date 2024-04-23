import java.util.Scanner;

public class BaekJoon1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("-");
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            String[] arr2 = arr[i].split("[+]");
            int t = 0;
            for (int j = 0; j < arr2.length; j++) {
                t += Integer.parseInt(arr2[j]);
            }
            if (i == 0) {
                ans += t;
                continue;
            }
            ans -= t;
        }

        System.out.println(ans);
    }
}
