import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());
        int result = str.toString().contentEquals(str.reverse().toString()) ? 1 : 0;
        System.out.println(result);
    }
}