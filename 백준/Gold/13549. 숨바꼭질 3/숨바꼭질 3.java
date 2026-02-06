import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int[1000001];
        Arrays.fill(visited, -1);

        Deque<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == k) {
                System.out.println(visited[x]);
                return;
            }
            // 곱하기, 뒤로가기, 앞으로 가기 순으로 계산
            int[] nextNode = {x * 2, x - 1, x + 1};

            for (int next : nextNode) {
                if (next >= 0 && next <= 100000 && visited[next] == -1) {
                    // 순간이동의 경우를 먼저 처리
                    if (next == x * 2) {
                        visited[next] = visited[x];
                        q.addFirst(next); //맨 앞으로 처리
                    } else {
                        visited[next] = visited[x] + 1;
                        q.addLast(next);
                    }
                }
            }

        }
    }
}
