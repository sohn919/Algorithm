import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		HashSet<String> Hset = new HashSet<>();
		for(int i=0; i<N; i++) {
			Hset.add(br.readLine());
		}
		int count = 0;
		for(int i=0; i<M; i++) {
			int temp = Hset.size();
			String s = br.readLine();
			Hset.add(s);
			if(Hset.size() == temp)
				count++;
			else
				Hset.remove(s);
		}
		System.out.print(count);
	}
}