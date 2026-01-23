import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n+5][m+5];
        visited = new int[n+5][m+5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                //익은 토마토는 큐에 넣기
                if (arr[i][j] == 1) {
                    q.add(new int[] {i, j});
                }
            }
        }

        bfs();

        int value = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 안익은 토마토를 방문하지 않았다면 -1 출력 후 종료
                if (arr[i][j] == 0 && visited[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                value = Math.max(value, visited[i][j]);
            }
        }

        System.out.println(value);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];

                // 인덱스 벗어나지 않도록 범위 체크
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    // 안익은 토마토인데 아직 방문 안했다면 큐에 넣기
                    if(arr[newX][newY] == 0 && visited[newX][newY] == 0) {
                        visited[newX][newY] = visited[nowX][nowY]+1;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
