import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		while(T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.valueOf(st.nextToken());
			int M = Integer.valueOf(st.nextToken());
			st = new StringTokenizer(br.readLine());
			LinkedList<int[]> q = new LinkedList<>();
			for(int i=0; i<N; i++) {
				q.add(new int[] {i, Integer.valueOf(st.nextToken())});
			}
			int cnt = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				boolean flag = false;
				int[] temp = q.poll();
				if(temp[0] == M)
					flag = true;
				for(int j=0; j<q.size(); j++) {
					if(temp[1] < q.get(j)[1]) {
						q.add(temp);
						flag = false;
						break;
					}
				}
				if(q.size() < size)
					cnt++;
				if(flag) {
					list.add(cnt);
					break;
				}
			}
			T--;
		}
		for(int a : list)
			System.out.println(a);
	
	}
}