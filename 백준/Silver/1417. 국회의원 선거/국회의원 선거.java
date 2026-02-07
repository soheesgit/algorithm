import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        // 나머지 후보들의 표를 내림차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;

        // 큐의 최댓값이 다솜이 표보다 크거나 같은 동안 반복
        while (!pq.isEmpty() && pq.peek() >= m) {
            int maxVote = pq.poll(); // 가장 많은 표 추출
            maxVote--;
            m++;
            cnt++;
            pq.add(maxVote);
        }

        System.out.println(cnt);

    }
}
