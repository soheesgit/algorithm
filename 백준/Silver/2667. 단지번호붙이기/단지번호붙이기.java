import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n+5][n+5];
        visited = new boolean[n+5][n+5];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();

            for (int j = 0; j < n; j++) {
                arr[i][j] = (temp.charAt(j) - '0');
            }
        }

        int cnt = 0; //총 단지수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) { //집이 있고, 방문x일때만 탐색
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        Collections.sort(answer);
        System.out.println(cnt);
        for (int i:answer) {
            System.out.println(i);
        }

    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int k = 0; k < 4; k++) {
                int nextX = nowX + dx[k];
                int nextY = nowY + dy[k];

                // 인덱스 범위를 초과하지 않는지 + 첫 방문인지 확인
                if (nextX < n && nextX >= 0 && nextY < n && nextY >= 0
                        && arr[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    q.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

        answer.add(cnt);


    }
}
