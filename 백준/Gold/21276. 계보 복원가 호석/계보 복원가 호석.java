import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> Tmap = new TreeMap<>();
        ArrayList<String>[] arr = new ArrayList[N+1];
        ArrayList<String>[] arr2 = new ArrayList[N+1];
        int[] degree = new int[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
            arr2[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        //해쉬 맵을 통해 이름에 순번을 부여
        for(int i=1; i<=N; i++) {
            String s = st.nextToken();
            Tmap.put(s, i);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String e = st.nextToken();
            arr[Tmap.get(e)].add(s);
            degree[Tmap.get(s)]++;
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<String> answer = new ArrayList<>();
        for(String s : Tmap.keySet()) {
            if(degree[Tmap.get(s)] == 0) {
                q.add(Tmap.get(s));
                answer.add(s);
            }
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            for(String next : arr[temp]) {
                int value = Tmap.get(next);
                degree[value]--;
                if(degree[value] == 0) {
                    q.add(value);
                    arr2[temp].add(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for(String s : answer) {
            sb.append(s + " ");
        }
        sb.append("\n");

        for(String s : Tmap.keySet()) {
            sb.append(s).append(" " + arr2[Tmap.get(s)].size() + " ");
            Collections.sort(arr2[Tmap.get(s)]);
            for(String str : arr2[Tmap.get(s)]) {
                sb.append(str + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}