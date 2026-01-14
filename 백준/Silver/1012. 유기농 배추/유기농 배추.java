import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int m, n;

    static int[] dx = {0, 0, -1, 1}; //상하좌우
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //테스트 케이스의 갯수


        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[m+1][n+1]; //0 based
            visited = new boolean[m+1][n+1];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int temp1 = Integer.parseInt(st.nextToken());
                int temp2 = Integer.parseInt(st.nextToken());

                arr[temp1][temp2] = 1;
            }

            int cnt = 0;
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (arr[j][l] == 1 && !visited[j][l]) {
                        bfs(j, l);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    public static void bfs(int firstX, int firstY) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(firstX, firstY));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            visited[x][y] = true;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 인덱스가 범위를 넘어가지 않도록
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    // 아직 방문X, 양배추가 심어져있을 경우
                    if (!visited[nx][ny] && arr[nx][ny] == 1) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }

        }
    }
}
