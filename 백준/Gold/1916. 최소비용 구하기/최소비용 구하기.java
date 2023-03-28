import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//정점과 가중치를 저장할 Node
class Node implements Comparable<Node> {
    int E, value;
    public Node(int E, int value) {
        this.E = E;
        this.value = value;
    }
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());
        //인접 리스트 그래프 생성
        ArrayList<Node>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.valueOf(st.nextToken());
            int E = Integer.valueOf(st.nextToken());
            int value = Integer.valueOf(st.nextToken());
            arr[S].add(new Node(E, value));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken());
        int end = Integer.valueOf(st.nextToken());
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.add(new Node(start, 0));
        //check 배열을 통해 이미 방문한 노드는 제외
        boolean[] check = new boolean[N+1];
        int[] answer = new int[N+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        //처음 방문하는 노드는 0으로 초기화
        answer[start] = 0;
        while(!pQ.isEmpty()) {
            Node o = pQ.poll();
            if(check[o.E])
                continue;
            check[o.E] = true;
            for(Node p : arr[o.E]) {
                answer[p.E] = Math.min(answer[o.E] + p.value, answer[p.E]);
                pQ.add(new Node(p.E, answer[p.E]));
            }
        }
        System.out.println(answer[end]);
    }
}