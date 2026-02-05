import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
        }

        int[][] dp = new int[n][3];
        // 첫번째 dp[0][] 는 각자 색깔의 최솟값으로 채워넣기
        for (int i = 0; i < 3; i++) dp[0][i] = arr[0][i];

        for (int i = 1; i < n; i++) {
        // dp 배열에, 다른 집 색깔들을 더한 값과 더해서 비교
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + arr[i][2];
        }

        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));


    }
}
