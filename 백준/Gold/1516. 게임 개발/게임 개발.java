import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] indegree = new int[N+1];
        int[] buildingValue = new int[N+1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value = Integer.valueOf(st.nextToken());
            buildingValue[i] = value;
            while(true) {
                int tmp = Integer.valueOf(st.nextToken());
                if(tmp == -1)
                    break;
                arr[tmp].add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0)
                Q.add(i);
        }
        int[] answer = new int[N+1];
        while (!Q.isEmpty()) {
            int temp = Q.poll();
            for(int a : arr[temp]) {
                indegree[a]--;
                answer[a] = Math.max(answer[a], answer[temp] + buildingValue[temp]);
                if(indegree[a] == 0)
                    Q.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++)
            sb.append(answer[i] + buildingValue[i]).append("\n");
        System.out.print(sb);
    }
}