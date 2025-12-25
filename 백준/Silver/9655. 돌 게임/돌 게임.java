import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 1) System.out.println("SK");
        else System.out.println("CY");

    }
}

/*
돌1인 경우 상근1 | 상근 우승
돌2인 경우 상근1 창영1 | 창영 우승
돌3인 경우 상근3 | 상근 우승
돌4인 경우 상근1 창1 상1 창1 / 상근3 창영1 = 창영 우승
돌5인 경우 상3 창1 상1 / 상1 창3 상1 = 상근 우승
돌6인 경우 상3 창3 / 상1 창1 * 3 = 창영 우승
돌7인 경우 상3 창3 1 / 상1 창1 *3 상1 = 상근우승
돌8인 경우 창영우승
돌9인 경우 상3 창3 상3 = 상근 우승

홀수? 상근 우승
짝수?  창영우승
 */