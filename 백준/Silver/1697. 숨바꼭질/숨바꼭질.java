import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer=0;
	public static void BFS() {
		Queue<Integer> Q = new LinkedList<>();
		int[] visited = new int[100001];
		Q.add(N);
		while(!Q.isEmpty()) {
			int tmp = Q.poll();
			if(tmp == M) {
				answer = visited[tmp];
				return;
			}
			for(int i=0; i<3; i++) {
				int next = tmp;
				if(i == 0)
					next = next + 1;
				else if(i == 1)
					next = next - 1;
				else if(i == 2)
					next = next * 2;
				if(next > 100000 || next < 0 || visited[next] > 0)
					continue;
				Q.add(next);
				visited[next] = visited[tmp] + 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		BFS();
		System.out.print(answer);
	}
}