import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+5];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[45][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        // dp의 수가 작으니까 모든 dp 값에 저장해두기
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dp[arr[i]][0] + " " + dp[arr[i]][1]);
        }
    }
}
/*
[0] => 0 1번 출력, 1 0번 출력
[1] => 0 0번 출력, 1 1번 출력
[2] => f(1)과 f(0)호출. 그럼 [0]과 [1] 더하기
[3] => f(2)와 f(1)호출. [2]와 [1] 더하기
 */