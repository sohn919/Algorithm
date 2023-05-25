import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		HashMap<String, Integer> Hmap = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			Hmap.put(br.readLine(), 1);
		}
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			Hmap.put(s, Hmap.getOrDefault(s, 0) + 1);
			if(Hmap.get(s) == 2)
				arr.add(s);
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for(String s : arr) {
			System.out.println(s);
		}
	}
}