import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int plus = Integer.parseInt(br.readLine());
        h += (m + plus) / 60;
        m = (m + plus) % 60;
        if(h >= 24) h -= 24;
        System.out.println(h + " " + m);
    }
}