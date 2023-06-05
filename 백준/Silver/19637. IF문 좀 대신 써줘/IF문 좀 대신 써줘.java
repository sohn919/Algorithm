import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] title = new String[N+1];
        int[] score = new int[N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            score[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int result = binarySearch(score, Integer.parseInt(br.readLine()));
            sb.append(title[result]).append("\n");
        }
        System.out.print(sb);
    }

    public static int binarySearch(int[] score, int num) {
        int start = 0, end = score.length - 1;
        int mid;
        while(true) {
            mid = (start + end) / 2;
            if(mid == 0) return 1;
            else if(score[mid-1] < num && num <= score[mid]) return mid;
            else if(score[mid-1] >= num) end = mid - 1;
            else start = mid + 1;
        }
    }
}