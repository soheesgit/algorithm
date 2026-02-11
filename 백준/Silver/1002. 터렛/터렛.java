import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 스트링이 비어있을 경우를 대비해 예외 처리를 고려할 수 있으나, 
        // 백준 환경에서는 보통 첫 줄에 T가 확실히 들어옵니다.
        String line = br.readLine();
        if (line == null) return;
        
        int T = Integer.parseInt(line);

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            System.out.println(tangent_point(x1, y1, r1, x2, y2, r2));
        }
    }

    // 접점 개수 구하는 함수
    public static int tangent_point(int x1, int y1, int r1, int x2, int y2, int r2) {
    
        // 중점간 거리의 제곱 (피타고라스 정리)
        int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); 

        // case 1 : 두 원이 일치할 때 (무한대)
        if(x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        
        // case 2-1 : 두 원이 멀리 떨어져 안 만날 때
        else if(distance_pow > Math.pow(r1 + r2, 2)) {
            return 0;
        }

        // case 2-2 : 한 원이 다른 원 안에 있으면서 만나지 않을 때
        else if(distance_pow < Math.pow(r2 - r1, 2)) {
            return 0;
        }
        
        // case 3-1 : 내접할 때 
        else if(distance_pow == (int)Math.pow(r2 - r1, 2)) {
            return 1;
        }
        
        // case 3-2 : 외접할 때 
        else if(distance_pow == (int)Math.pow(r1 + r2, 2)) {
            return 1;
        }
        
        // 그 외 (두 점에서 만날 때)
        else {
            return 2;
        }        
    }
}