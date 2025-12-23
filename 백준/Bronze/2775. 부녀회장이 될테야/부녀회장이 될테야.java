import java.io.*;

public class Main {
    // DP 의 2차원배열. 그냥 여기 인원수 다 기입!
    static int[][] arr = new int[15][15];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] floor = new int[t];
        int[] nums = new int[t];
        for (int i = 0; i < t; i++) {
            floor[i] = Integer.parseInt(br.readLine()); //층수
            nums[i] = Integer.parseInt(br.readLine()); //몇호
        }

        for (int i = 1; i < 15; i++) {
            arr[0][i] = i; //0층 전부 매기기
        }
        // arr가 작으니 전부 층수를 매겨야한다.
        for (int i = 1; i < 15; i++) {
            // 1호는 왼쪽 층수가 없다. 그냥 1
            arr[i][1] = 1;
            for (int j = 2; j < 15; j++) {
                // 자신 바로 아래층 + 자신의 왼쪽 층
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        for (int i = 0; i < t; i++) {
            // 내 층수가 할당되었으니, 그 값을 출력한다
            System.out.println(arr[floor[i]][nums[i]]);
//        for (int j = 1; j < 15; j++) {
//            System.out.print(arr[i][j] + " ");
//        }
//        System.out.println();
//        }
        }
    }
}
