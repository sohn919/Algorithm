import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Sticker {
    int emo, copy, cnt;
    public Sticker(int emo, int copy, int cnt) {
        this.emo = emo;
        this.copy = copy;
        this.cnt = cnt;
    }
}

public class Main {

    static int N;

    public static int solution() {
        Queue<Sticker> q = new LinkedList<>();
        boolean[][] visited = new boolean[2000][2000];
        q.add(new Sticker(1, 0, 0));
        while(!q.isEmpty()) {
            Sticker cur = q.poll();
            if(cur.emo == N) {
                return cur.cnt;
            }
            for(int i=0; i<3; i++) {
                if(i == 0) {
                    if(!visited[cur.emo][cur.emo]) {
                        visited[cur.emo][cur.emo] = true;
                        q.add(new Sticker(cur.emo, cur.emo, cur.cnt + 1));
                    }
                } else if(i == 1) {
                    if(cur.copy != 0 && cur.emo +  cur.copy < 2000 && !visited[cur.copy][cur.emo + cur.copy]) {
                        visited[cur.copy][cur.emo + cur.copy] = true;
                        q.add(new Sticker(cur.emo + cur.copy, cur.copy, cur.cnt + 1));
                    }
                } else {
                    if(cur.emo - 1 > 0 && !visited[cur.copy][cur.emo - 1]) {
                        visited[cur.copy][cur.emo - 1] = true;
                        q.add(new Sticker(cur.emo - 1, cur.copy, cur.cnt + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(solution());
    }
}