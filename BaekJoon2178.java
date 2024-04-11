import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2178 {
    private static char[][] m;
    private static boolean[][] visited;
    private static final int[] xd = {1, -1, 0, 0};
    private static final int[] yd = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        m = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            m[i] = br.readLine().toCharArray();
        }

        BFS();
    }

    private static class Coordinate {
        int x;
        int y;
        int cnt;

        private int getX() {
            return this.x;
        }

        private int getY() {
            return this.y;
        }

        private int getCnt() {
            return this.cnt;
        }

        Coordinate(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static void BFS() {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0, 0, 1));
        visited[0][0] = true;
        int x, y, nx, ny;

        while (!q.isEmpty()) {
            Coordinate t = q.poll();
            x = t.getX();
            y = t.getY();

            if (x == m.length - 1 && y == m[0].length - 1) {
                System.out.println(t.getCnt());
                return;
            }

            for (int i = 0; i < 4; i++) {
                nx = x + xd[i];
                ny = y + yd[i];

                if (nx >= 0 && nx < m.length && ny >= 0 && ny < m[0].length) {
                    if (m[nx][ny] == '1' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Coordinate(nx, ny, t.getCnt() + 1));
                    }
                }
            }
        }
    }
}
