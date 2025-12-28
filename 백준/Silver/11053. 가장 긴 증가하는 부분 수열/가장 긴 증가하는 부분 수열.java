import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[1001];

        Arrays.fill(dp, 1);

        int max = 1; //dp[num-1]이 늘 정답이 아님
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i; j++) { //내 앞의 숫자까지만 확인하기
                //나보다 더 작은숫자이며, 그 줄이 제일 긴 줄이라면 뒤에 서기
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > max)  max = dp[i];
        }

        System.out.println(max);
    }
}
