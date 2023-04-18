import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = 0;
    static ArrayList<Integer>[] arr;
    static int[] combi;
    static boolean[] visit;

    // 순서 조합 -> 야구 경기

    //순서 조합
    public static void DFS(int L) {
        if(L == 10) {
            answer = Math.max(solution(), answer);
        }
        else {
            if(L == 4)
                L++;
            for(int i=1; i<=9; i++) {
                if(visit[i])
                    continue;
                combi[L] = i;
                visit[i] = true;
                DFS(L+1);
                visit[i] = false;
            }
        }
    }

    public static int solution() {
        // 처음 플레이어는 1번 부터
        int player = 1;
        int score = 0;
        for(int i=0; i<N; i++) {
            boolean[] select = new boolean[4];
            int outCount = 0;
            while(outCount < 3) {
                int hit = arr[combi[player]].get(i);
                player++;
                if(player == 10)
                    player = 1;
                if(hit == 0) {
                    outCount++;
                    continue;
                }
                if(hit == 1) {
                    for(int j=3; j>=1; j--) {
                        if(select[j]) {
                            if(j==3) {
                                score++;
                                select[j] = false;
                                continue;
                            }
                            select[j+1] = true;
                            select[j] = false;
                        }
                    }
                    select[1] = true;
                }
                if(hit == 2) {
                    for(int j=3; j>=1; j--) {
                        if(select[j]) {
                            if(j==3 || j==2) {
                                score++;
                                select[j] = false;
                                continue;
                            }
                            select[j+2] = true;
                            select[j] = false;
                        }
                    }
                    select[2] = true;
                }
                if(hit == 3) {
                    for(int j=3; j>=1; j--) {
                        if(select[j]) {
                            score++;
                            select[j] = false;
                        }
                    }
                    select[3] = true;
                }
                if(hit == 4) {
                    for(int j=3; j>=1; j--) {
                        if(select[j]) {
                            score++;
                            select[j] = false;
                        }
                    }
                    score++;
                }
            }

        }
        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[10];
        combi = new int[10];
        combi[4] = 1;
        visit = new boolean[10];
        visit[1] = true;
        for(int i=0; i<10; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++) {
                arr[j].add(Integer.parseInt(st.nextToken()));
            }
        }
        DFS(1);
        System.out.print(answer);
    }
}