import java.util.*;

class Conference implements Comparable<Conference>{
	int start, end;
	Conference(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Conference o) {
		if(this.end == o.end)
			return this.start - o.start;
		else
			return this.end - o.end;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Conference> arr = new ArrayList<>();
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			arr.add(new Conference(start, end));
		}
		Collections.sort(arr);
		int answer = 0;
		int time = 0;
		for(Conference c : arr) {
			if(time <= c.start) {
				time = c.end;
				answer++;
			}
		}
		System.out.print(answer);
	}

}
