import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); //최댓값으로 초기화

        // if문 없을 시, 4 입력 시 인덱스오류가 남
        if (n >= 3) dp[3] = 1;
        if (n >= 5) dp[5] = 1;

        for (int i = 6; i <= n; i++) { //i = 무게
            dp[i] = Math.min(dp[i - 3], dp[i - 5]);
            if (dp[i] != Integer.MAX_VALUE) dp[i]++;
        }

        if (dp[n] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}

/*

내가 지금 무게 i를 완성하려면,
내 바로 전 단계(i-3 또는 i-5)의 봉지 개수 중 무엇을 참고해야 할까?
반복문을 돌때 i는 봉지 개수가 아니라 무게를 기준으로 반복문을 돌아야됨.

    i = 6일때 6kg를 완성하려면 dp[i-3]의 값과 dp[i-5] 중 더 작은 값에 +1해서 저장.
    i = 15일때 15kg를 완성하려면 dp[i-3]의 값과 dp[i-5] 중 더 작은 값에 +1해서 저장.
        dp[12]에는 4가 저장되어있고 dp[10]엔 2가 저장되어있음.

처음에는 i를 봉지 갯수 기준으로 반복문을 돌았는데, 완전탐색/BFS의 형태가 되어
너무 시간과 공간을 많이 잡아먹는 형태가 되었었다.
그당시에도 과도하게 반복문을 돈다고 생각했는데, DP 방식을 보니 훨씬 깔끔하고 낭비가 없다.
조금 더 DP스럽게 문제를 푸는 법을 공부하게 된 것 같다.
 */
