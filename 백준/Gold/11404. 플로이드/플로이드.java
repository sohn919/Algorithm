import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        //초기 거리 테이블 초기화
        int[][] dis = new int[N+1][N+1];
        //초기 거리를 충분히 큰 값으로 초기화
        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++) {
                if(i == j)
                    dis[i][j] = 0;
                else
                    dis[i][j] = 100000001;
            }
        }
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(dis[s][e] > v)
                dis[s][e] = v;
        }

        //플로이드 워셜 알고리즘
        for(int i=1; i<=N; i++) {
            for (int j=0; j<=N; j++) {
                for (int k=0; k<=N; k++) {
                    if(dis[j][k] > dis[j][i] + dis[i][k]) {
                        dis[j][k] = dis[j][i] + dis[i][k];
                    }
                }
            }
        }
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(dis[i][j] == 100000001) {
                    System.out.print("0 ");
                }
                else {
                    System.out.print(dis[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}