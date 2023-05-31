import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> str = new TreeSet<>((o1, o2) -> {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else if(o1.length() > o2.length()) return 1;
                else return -1;
        });
        for(int i=0; i<N; i++) {
            str.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        str.forEach(x -> sb.append(x).append("\n"));
        System.out.print(sb);
    }
}