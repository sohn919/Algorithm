import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String str = br.readLine();
        for(int i=0; i<str.length(); i++) {
            int temp = str.charAt(i) - 'A';
            if(temp == 18 || temp == 21 || temp >= 24) {
                sum += temp / 3 + 2;
                continue;
            }
            sum += temp / 3 + 3;
        }
        System.out.println(sum);
    }
}
