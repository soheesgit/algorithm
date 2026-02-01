import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int maxValue = 1;
    static int maxHeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        for (int h = 0; h < maxHeight; h++) { //높이
            visited= new int[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > h && visited[i][j] == 0) {
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }

            maxValue = Math.max(maxValue, cnt);
        }

        System.out.println(maxValue);
    }

    static void bfs(int x, int y, int height) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = 1;
        q.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int nowX = temp[0];
            int nowY = temp[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    // 아직 방문 X. 잠기지않은높이이면 방문
                    if (visited[nextX][nextY] == 0 && arr[nextX][nextY] > height) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = 1;
                    }
                }
            }
        }
    }
}