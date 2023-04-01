import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static ArrayList<Integer> arr;
    public static int binarySearch(int n) {
        int lt = 0;
        int rt = arr.size() - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr.get(mid) > n) {
                rt = mid - 1;
            }
            else if(arr.get(mid) < n) {
                lt = mid + 1;
            }
            else {
                return mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> Tset = new TreeSet<>();
        int N = Integer.parseInt(br.readLine());
        int[] arrs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int a = Integer.parseInt(st.nextToken());
            Tset.add(a);
            arrs[i] = a;
        }
        arr = new ArrayList<>(Tset);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(binarySearch(arrs[i]) + " ");
        }
        System.out.print(sb);
    }
}