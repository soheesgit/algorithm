import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n+5][n+5];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            arr[temp1][temp2] = 1;
            arr[temp2][temp1] = 1;
        }

        //bfs
        boolean[] visited = new boolean[n+5];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
             for (int i = 1; i <= n; i++) {
                // 방문X이고, 연결되어있는 곳 Q에 add하기
                if (!visited[i] && arr[temp][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                    cnt++;
                }
             }
        }

        System.out.println(cnt);
    }
}

/*
그래프. BFS?
 */