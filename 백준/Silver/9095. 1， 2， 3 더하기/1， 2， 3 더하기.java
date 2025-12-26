import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i]  = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[13];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for (int i = 0; i < N; i++) {
            System.out.println(dp[arr[i]]);
        }


    }
}

/*
1 = 1 -> 1
2 = 1+1, 2 -> 2
3 = 1+1+1, 1+2, 2+1, 3 -> 4
4 = 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 3+1, 1+3->7 (1+2+4)
5 = 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1,
    2+2+1, 2+1+2, 1+2+2,
    3+1+1, 1+3+1, 1+1+3,
    3+2, 2+3 -> 13 (2+4+7)
6 = 1+1+1+1+1+1,
    1+1+1+1+2, 1+1+1+2+1, 1+1+2+1+1, 1+2+1+1+1, 2+1+1+1+1,
    2+2+1+1, 2+1+2+1, 1+2+2+1, 1+1+2+2, 1+2+1+2, 2+1+1+2,
    3+1+1+1, 1+3+1+1, 1+1+3+1, 1+1+1+3,
    1+2+3, 1+3+2, 2+1+3, 3+1+2, 2+3+1, 3+2+1
    2+2+2, 3+3-> 24 (4+7+13)
7 = 44 (7+13+24)

 */