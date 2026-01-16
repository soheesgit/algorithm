import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+5][n+5];
        visited = new boolean[n+5];
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    cnt++;
                    bfs(i);
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int a) {
        Queue<Integer> q = new LinkedList<>();
        visited[a] = true;
        q.add(a);

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i <= n; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
