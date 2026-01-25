
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited  = new int[100001];
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        visited[n] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == k) { //정답일 경우
                System.out.println(visited[x]);
                return;
            }
            if (x + 1 <= 100000 && visited[x+1] == 0) {
                visited[x+1] = visited[x] + 1;
                q.add(x+1);
            }
            if (x - 1 >= 0 && visited[x-1] == 0) {
                visited[x-1] = visited[x] + 1;
                q.add(x-1);
            }
            if (x * 2 <= 100000 && visited[x*2] == 0) {
                visited[x*2] = visited[x] + 1;
                q.add(x*2);
            }
        }
    }
}

/*
돌면서 -1, +1, *2일때의 시간을 전부 배열에 저장.
 */