import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[] list, check, arr;
    public static void combi(int a, int L, int len) {
        if(L == 6) {
            for(int i : list)
                sb.append(i + " ");
            sb.append("\n");
        }
        else {
            for(int i=a; i<len; i++) {
                if(check[i] > 0)
                    continue;
                check[i] = 1;
                list[L] = arr[i];
                combi(i, L+1, len);
                check[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        sb = new StringBuilder();
        list = new int[6];
        while(!(s = br.readLine()).equals("0")) {
            String[] str = s.split(" ");
            arr = new int[Integer.valueOf(str[0])];
            check = new int[Integer.valueOf(str[0])];
            for(int i=0; i<arr.length; i++) {
                arr[i] = Integer.valueOf(str[i+1]);
            }
            combi(0,0, arr.length);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}