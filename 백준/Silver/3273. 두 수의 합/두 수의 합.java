import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        Collections.sort(list);
        int lt = 0;
        int rt = list.size()-1;
        int answer = 0;
        while(lt < rt) {
            if(list.get(lt) + list.get(rt) > M) {
                rt--;
            }
            else if(list.get(lt) + list.get(rt) < M) {
                lt++;
            }
            else {
                answer++;
                lt++;
            }
        }
        System.out.print(answer);
    }
}