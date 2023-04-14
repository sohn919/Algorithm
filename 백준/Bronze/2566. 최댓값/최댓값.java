import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MIN_VALUE;
        int x=0, y=0;
        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(answer < temp) {
                    answer = temp;
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        System.out.println(answer);
        System.out.print(x + " " + y);
    }
}