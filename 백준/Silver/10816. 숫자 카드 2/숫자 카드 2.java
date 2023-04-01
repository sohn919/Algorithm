import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static int binarySearch(int[] arr, int n) {
        int lt = 0;
        int rt = arr.length - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] < n) {
                lt = mid + 1;
            }
            else if(arr[mid] > n) {
                rt = mid - 1;
            }
            else {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> Hmap = new HashMap<>();
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            Hmap.put(a, Hmap.getOrDefault(a, 0) + 1);
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            int a = binarySearch(arr, temp);
            if(a == 1) {
                sb.append(Hmap.get(temp) + " ");
            }
            else {
                sb.append(0 + " ");
            }
        }

        System.out.print(sb);

    }
}