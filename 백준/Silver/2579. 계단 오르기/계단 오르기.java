import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[301];
        int[] dp = new int[301]; //값이 작으니 런타임에러 방지. 전부 선엉ㄴ

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[1], arr[0]) + arr[2];

        for (int i = 3; i < num; i++) {
            //지금 4에 저장될걸 찾는거니까
            // 1->2->4의 경우와 1->3->4의 경우를 볼 수 있다.

            // 1->2->4의 경우.
            // 근데 그냥 2->4를 보자. 왜냐면 2에는 최고값이 저장이 이미 되어있을거니까
            int temp1 = dp[i - 2];

            // 1->3->4의 경우.
            // 그니까 dp[1]->arr[3]->arr[4] 보기.
            // dp[3]으로 보면 이미 최고값이 저장되어있으니까 dp[1]을 보기
            int temp2 = dp[i-3] + arr[i - 1];
            dp[i] = Math.max(temp1, temp2) + arr[i];
        }

        System.out.println(dp[num - 1]);


    }

}

/*
10(1) 20(2) 15(3) 25(4) 10(5) 20(6)

0->2 20
    -> 3 = 35 (4로 못감. 5로 가야됨)
        -> 5 = 45 -> 6 = 75
    -> 4 = 45 (6으로만) -> 6 = 65
1->2 30 그러면 3으로 못감. 무조건 4로 가야함.
    -> 4 = 55 (5로 가면 세개를 연속으로 가야해서 안됨. 6으로 갈 수 있다)
        -> 6 = 75
1->3 25
    -> 4 = 50 (6으로만)
        -> 6 = 70
    -> 5 = 30 (6으로만)
        -> 6 = 50

1->2->4->6 순으로 밟는게 가장 좋다.
왜 이 단계로 가는게 좋지? 어떤 규칙이 있지?
dp는 앞의 숫자를 기억하고 가는게 좋은거다. 근데 앞에껄 밟으면 안된다.

내가 2번이잖아? 그러면 2->4->6으로 갈 수 있다. 2->3->5로도 갈 수 있다.
근데 2번으로 갈 때 1번을 밟았다면 2->3->5를 못간다.
그럼 2번을 건너뛰어야하는가?
내가 3번이잖아? 그러면 3->5->6으로도 갈 수 있고 4->6으로도 갈 수 있다.

 */