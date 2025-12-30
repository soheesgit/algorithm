import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] dp = new int[50][2]; //0번 배열은 A, 1번 배열은 B
        dp[1][1] = 1;

        for (int i = 2; i <= num; i++) {
            // A에는 이전 배열의 B값만큼 할당한다
            dp[i][0] = dp[i - 1][1];

            //B에는 이전 배열의 B값 +A값
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        System.out.println(dp[num][0] + " "+ dp[num][1]);
    }
}

/*
(A의 개수, B의 개수)
B (0 1) A의 갯수만큼 B에 더하고, A는 0
BA (1 1) A는 i-1의 B의갯수, B는 i-1의 B값을 가져오고, A의 갯수만큼 더한다.
BAB (1 2) a는
B A B B A (2 3)
B A B B A B A B (3 5)
BAB BABAB BAB BA (5 8)
 */