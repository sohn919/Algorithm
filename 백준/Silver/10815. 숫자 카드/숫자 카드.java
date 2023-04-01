import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int a = binarySearch(arr, Integer.parseInt(st.nextToken()));
            sb.append(a + " ");
        }

        System.out.print(sb);

    }
}