import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2))
                    return o1 - o2;
                else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) {
                if(pQ.isEmpty()) {
                    sb.append("0").append("\n");
                }
                else
                    sb.append(pQ.poll()).append("\n");
            }
            else
                pQ.add(temp);
        }

        System.out.println(sb);
    }
}
