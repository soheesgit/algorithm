import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] left;
    static int[] right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        left = new int[n];
        right = new int[n];

        for (int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            left[i] = Integer.parseInt(st.nextToken());
            right[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            int[][] dp = new int[left[i]][right[i]];

            for(int j = 0; j < left[i]; j++) {

                for (int k = j; k < right[i]; k++) {
                    if (j == 0) { //초기값 채우기
                        dp[j][k] = k + 1;
                        continue;
                    }
                    // 내 이전까지의 다리 개수 + 나보다 더 작은거에 추가하기
                    dp[j][k] = dp[j][k-1] + dp[j-1][k-1];
                }
            }

            System.out.println(dp[left[i]-1][right[i]-1]);
        }



    }
}

/*
내 앞의 다리가 이어진 곳보다 앞으로 못감.
즉, 내 바로 앞의 서쪽 다리가 동쪽 3에 연결되었다면,
나는 4 이후의 다리에만 연결할 수 있다.

2차원 배열 DP[5][5]가 있다.
11 12 13 14 15
21 22 23 24 25
31 32 33 34 35
41 42 43 44 45
51 52 53 54 55

그 앞에 몇개가 이어져있는지 저장한 값 더하기 이번에 이을 값.
1번 라인은 전부 첫 시작이기 때문에, 사이트 개수만큼 저장한다.

오른쪽 숫자는 왼쪽보다 늘 크거나 같아야한다. (작은 경우는, 서쪽의 다리 연결을 못함.)
    22 잇는다고 하면, 11은 이어져있다. 22엔 1을 저장한다.
    23을 잇는다고 하면, 11-23, 12-23 이을 수 있다(경우 2개). 2를 저장.
    24를 잇는다고 하면, 11-24, 12-24, 13-24 이을 수 있다. 3을 저장.

31,32은 오른쪽 숫자가 왼쪽보다 작아서 해당X.
현재는 33, 34만 보면 된다.
    33을 이으면 22에 저장된 값을 저장한다. (1)
    34를 이으면 11-22-34 11-23-34, 12-23-34 가능하다. (3)
    34까지로 하면 22를 이을 경우의 수 + 23을 잇는 경우의수이다. (33의 경우+23의 경우)

41, 42, 43은 해당 X.
    44를 이으면 33까지 이은 경우의 수와 같다. (1)
    45를 이으면 34까지 잇고 거기에 45를 추가로 잇는 경우 (4)
    더하면 1+4=5

51, 52, 53, 54는 해당 X.
    55를 이으려면 44의 경우의 수와 같다.
    결국 답은 1이다.
 */