import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MAX_NUM = 1_100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[MAX_NUM + 1];
        arr[1] = true;
        for(int i=2; i<=Math.sqrt(MAX_NUM); i++) {
            for(int j=i*i; j<=MAX_NUM; j+=i) {
                if(arr[j]) continue;
                arr[j] = true;
            }
        }

        for(int i=N; i<=MAX_NUM; i++) {
            if(!arr[i]) {
                if(checked(i)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }

    public static boolean checked(int num) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s).reverse();
        return s.equals(sb.toString());
    }
}