import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BigInteger[][] check;
    public static void combi(int n, int m) {
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i)
                    check[i][j] = new BigInteger("1");
                else
                    check[i][j] = check[i-1][j].add(check[i-1][j-1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        check = new BigInteger[101][101];
        combi(100, 100);
        System.out.println(check[n][m]);
    }
}