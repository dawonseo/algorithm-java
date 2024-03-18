import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> myDeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            while (!myDeque.isEmpty() && myDeque.getLast().num > t) {
                myDeque.removeLast();
            }
            myDeque.add(new Node(i, t));
            while (!myDeque.isEmpty() && myDeque.getFirst().index <= i - L) {
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().num + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int index;
        public int num;

        Node(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}
