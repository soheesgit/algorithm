import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 5];

        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);

    }
}

/*
2xn 을 채우잖아? 이 방법의 수를 전부 구해야함.
DP로 앞의 경우의 수를 계산해나가면서 계산.
DP 배열을 2차원으로 만들고 [2][n]
n 의 경우의 수를 더해가면서 탐색한다.
[2][1]의 경우에는 | 하나.
[2][2]의 경우에는 ||와 =로 ㅁ로 3개

 */