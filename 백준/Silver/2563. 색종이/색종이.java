import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[101][101];
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Point(x, y));
        }
        for(Point o : arr) {
            for(int i=o.x; i<o.x+10; i++) {
                for(int j=o.y; j<o.y+10; j++) {
                    board[i][j] = 1;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<=100; i++) {
            for(int j=0; j<=100; j++) {
                if(board[i][j] == 1)
                    answer++;
            }
        }
        System.out.print(answer);
    }
}