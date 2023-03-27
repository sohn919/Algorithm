import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x;
	String str;
	Point(int x, String str) {
		this.x = x;
		this.str = str;
	}
	@Override
	public int compareTo(Point o) {
		return this.x - o.x;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		List<Point> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			String str = st.nextToken();
			arr.add(new Point(x, str));
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(Point o : arr) {
			sb.append(o.x + " " + o.str + "\n");
		}
		System.out.print(sb);
	}
}