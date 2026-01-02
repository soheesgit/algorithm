import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, v;

    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n+5][n+5];
        visited = new boolean[n+5];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            graph[temp1][temp2] = 1;
            graph[temp2][temp1] = 1;
        }

        // DFS
        dfs(v);
        System.out.println();
        // BFS
        visited = new boolean[n+5];
        bfs();
    }
    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i); // 재귀 호출해 더 깊게 들어감
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int check = q.poll();
            System.out.print(check + " ");
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[check][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}


/*

DFS 는 깊이우선탐색으로 제일 왼쪽부터 깊게 들어간 다음에 맨 위로가서 다음 노드를 살펴본다.
BFS 는 너비우선탐색으로 제일 얕은순으로 검사하는거다.

   1 2 3 4
1    1 1 1
2  1     1
3  1     1
4  1 1 1 1
이렇게 매핑을 시킨다.

1번에서부터 탐색해보자.
V부터시작하니까 1번부터 탐색한다.
BFS 로 보면 1에서부터 1에 연결되어있는 모든 노드를 본다.
2->3->4.

DFS로 보면 1에서 처음에 연결되어있는 제일 작은 값 2를 본다.
그리고 2에 연결되어있는 제일 작은 값 4를 본다.
더 이상 연결할 게 없으니까 돌아와서 2를 본다. 2도 연결될게 없으니까 다시 1을 본다.
1에 아직 탐색X인 3이 있다. 3으로간다.
 */