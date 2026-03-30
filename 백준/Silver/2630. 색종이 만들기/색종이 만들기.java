import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] arr;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void solve(int r, int c, int size) {
        boolean checking = check(r, c, size);

        // 만약 색깔이 모두 같다면
        if (checking) {
            if (arr[r][c] == 1) blue++;
            else white++;
        }
        else { //색깔이 모두 다르다면
            int newSize = size / 2;

            // 1~4사분면 재귀함수로 호출
            solve(r, c, newSize);
            solve(r+newSize, c, newSize);
            solve(r, c+newSize, newSize);
            solve(r+newSize, c+newSize, newSize);
        }
    }

    // 색깔 체크 함수
    public static boolean check(int r, int c, int size) {
        int color = arr[r][c];

        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if (arr[i][j] != color) return false;
            }
        }

        return true;
    }
}
