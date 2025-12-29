import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        arr = new int[20][2];
        dp = new int[20];
        for (int i = 1; i <= num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 소요 일 수
            arr[i][1] = Integer.parseInt(st.nextToken()); // 얻는 돈
        }

        for (int i = 1; i <= num; i++) {
            // 오늘 상담 X
            if (dp[i] < dp[i - 1]) dp[i] = dp[i - 1];

            // 상담 마지막날
            int nextDay = i + arr[i][0];
            if (nextDay <= num + 1) { //항상 퇴사 전까지만 상담
                //기존의 저장된 값과 오늘까지 번 돈+새롭게 벌 돈
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + arr[i][1]);
            }
        }

        int max = Math.max(dp[num], dp[num+1]);
        System.out.println(max);

    }
}
/*
한 일씩 확인한다.
1일차. 4일차 아침에 끝날 예정. dp[4]=10원
2일차. 7일차 아침에 끝날 예정. dp[7]=20원
3일차. 4일차 아침에 끝날 예정. 기존의 dp[4]의 숫자와 비교. 10원.
4일차. 어제 번돈에 오늘 번 돈을 더한다. dp[4]=30 
 */