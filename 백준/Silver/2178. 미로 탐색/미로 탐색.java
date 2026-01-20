import java.io.*;
import java.util.*;

class Node3 {
    int x;
    int y;

    Node3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 5][m + 5];
        int[][] answer = new int[n + 5][m + 5];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                //char -> String -> int로 바꾸어서 저장
                arr[i][j] = (temp.charAt(j)) - '0';
                answer[i][j] = -1;
            }
        }

        Queue<Node3> q = new LinkedList<>();
        q.add(new Node3(0, 0));
        answer[0][0] = 1;

        // 이중포문? 삼중포문? or while 문으로 Q?
        while (!q.isEmpty()) {
            Node3 node = q.poll();
            int currentX = node.x;
            int currentY = node.y;

            // 상하좌우가 이동할 수 있는 칸인지 확인.
            for (int direction = 0; direction < 4; direction++) {
                int newX = currentX + dx[direction];
                int newY = currentY + dy[direction];

                // 범위 벗어나지 않았는지확인
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    // 이동 가능한 길이며, 첫방문이면 최단거리임
                    if (arr[newX][newY] == 1 && answer[newX][newY] == -1) {
                        answer[newX][newY] = answer[currentX][currentY]+1;
                        q.add(new Node3(newX, newY));
                    }
                }
            }


        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(answer[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(answer[n - 1][m - 1]);


    }

}
