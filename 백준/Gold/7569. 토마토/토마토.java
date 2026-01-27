import java.io.*;
import java.util.*;

public class Main {

    static int n, m, h;
    static int[][][] arr;
    static int[][][] visited;
    static Queue<int[]> q = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0, 0, 0}; //왼쪽 오른쪽
    static int[] dy = {0, 0, -1, 1, 0, 0}; //위 아래
    static int[] dz = {0, 0, 0, 0, -1, 1}; //앞 뒤

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); //가로
        n = Integer.parseInt(st.nextToken()); //세로
        h = Integer.parseInt(st.nextToken()); //깊이

        arr = new int[h][n][m];
        visited = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int nowZ = p[0];
            int nowX = p[1];
            int nowY = p[2];

            for (int i = 0; i < 6; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                int newZ = nowZ + dz[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && newZ >= 0 && newZ < h) {
                    // 아직 방문 X이면서 안익은 토마토가 있을 경우.
                    if (visited[newZ][newX][newY] == 0 && arr[newZ][newX][newY] == 0) {
                        q.add(new int[]{newZ, newX, newY});
                        visited[newZ][newX][newY] = visited[nowZ][nowX][nowY] + 1;
                    }
                }
            }
        }

        int maxValue = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0 && visited[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    maxValue = Math.max(maxValue, visited[i][j][k]);
                }
            }
        }

        System.out.println(maxValue);

    }
}
