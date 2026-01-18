import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점 개수
        int M = Integer.parseInt(st.nextToken()); //노드 개수
        int K = Integer.parseInt(st.nextToken()); // 최단거리 결과 정점 찾기.
        int X = Integer.parseInt(st.nextToken()); //출발 정점

        // N, M, K가 너무 커서 메모리 초과가 날 수 있으니 ArrayList 사용
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());

        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B); //A에서 B로 이동하는 단방향도로
        }

        int[] answer = new int[N+5]; //최단거리를 담는 그래프
        Arrays.fill(answer, -1); //방문X는 -1로 초기화

        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        answer[X] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();

            //이미 K보다 큰 값이라면 계산할 필요가 없다.
            if (answer[temp] > K) continue;

            // 연결된 간선들을 탐구한다.
            for (int i : graph.get(temp)) {

                // 처음 방문한거면 그게 최단거리니까 그냥 첫 방문만 큐에 넣기
                if (answer[i] == -1) {
                    answer[i] = answer[temp] + 1;
                    q.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean find = false;

        for (int i = 1; i <= N; i++) {
            if (answer[i] == K) {
                sb.append(i).append("\n");
                find = true;
            }
        }

        if (!find) System.out.println(-1);
        else System.out.print(sb);
    }
}
