import java.util.*;
import java.io.*;

class Node2 {
    int x;
    int y;

    Node2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr;
        boolean[][] visited;
        int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break; //종료

            // 테스트케이스
            arr = new int[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            // bfs 코드
            Queue<Node2> q = new LinkedList<>();
            int cnt = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[j][i] == 1 && !visited[j][i]) {
                        q.add(new Node2(j, i));
                        visited[j][i] = true;
                        cnt++;

                        while (!q.isEmpty()) {
                            Node2 node = q.poll();
                            int x = node.x;
                            int y = node.y;

                            for (int k = 0; k < 8; k++) {
                                // 인덱스 침범하지 않았나 확인
                                if (x + dx[k] < w && x + dx[k] >= 0 && y + dy[k] < h && y + dy[k] >= 0) {
                                    // 상하좌우를 탐색한 뒤에, 방문하지 않은 섬이 있다면 Q에 추가
                                    if (arr[x + dx[k]][y + dy[k]] == 1 && !visited[x + dx[k]][y + dy[k]]) {
                                        q.add(new Node2(x + dx[k], y + dy[k]));
                                        visited[x + dx[k]][y + dy[k]] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(cnt);
        }

    }
}
