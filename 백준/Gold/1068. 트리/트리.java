import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] arr;
    static int answer = 0;
    static boolean[] check;

    public static void DFS(int num) {
        check[num] = true;
        int temp = 0;
        for(int a : arr[num]) {
            if(!check[a]) {
                DFS(a);
                temp++;
            }
        }
        if(temp == 0)
            answer++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        arr = new ArrayList[N];
        check = new boolean[N];
        for(int i=0; i<N; i++) {
            arr[i] = new ArrayList<>();
        }
        int parent = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int a = Integer.valueOf(st.nextToken());
            if(a == -1)
                parent = i;
            else {
                arr[a].add(i);
            }
        }
        int del = Integer.valueOf(br.readLine());

        //check 배열을 통해 삭제한 트리로 취급
        check[del] = true;
        if(check[parent]) {
            System.out.print(answer);
            return;
        }
        DFS(parent);

        System.out.print(answer);
    }
}