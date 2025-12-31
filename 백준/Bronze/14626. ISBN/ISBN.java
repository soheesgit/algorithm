import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int sum = 0;
        int[] weight = {1, 3};
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum += (str.charAt(i) - '0') * weight[i % 2];
            } else {
                idx = i;
            }
        }

        for (int i = 0; i < 10; i++) {
            //훼손된 숫자가 짝수 인덱스일 경우. 가중치가 3일 때
            // (총합 + 가중치 * 훼손값) % 10 == 0이여야한다.
            if (idx % 2 != 0 && (sum + (i * 3))% 10 == 0) {
                System.out.println(i);
                break;
            } else if (idx % 2 == 0 && (sum + i)% 10 == 0) {
                System.out.println(i);
                break;
            }
        }

    }
}
