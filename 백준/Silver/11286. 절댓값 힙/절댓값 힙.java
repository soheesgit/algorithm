import java.io.*;
import java.util.*;

class AbsoluteComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        int abs1 = Math.abs(o1);
        int abs2 = Math.abs(o2);

        if (abs1 == abs2) {
            // 절댓값이 같으면 실제 값이 작은 숫자를 앞으로
            if (o1 > o2) return 1; //o1이 크면 o2가 앞으로
            else if (o1 < o2) return -1; //o1이 크면 o1이 그대로 앞
            else return 0;
        }
        // 결과가 음수면 abs1이 작으니 그대로. 양수면 abs1이 더 크니 순서바꿈
        return abs1 - abs2;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new AbsoluteComparator());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(temp);
            }
        }
    }
}
