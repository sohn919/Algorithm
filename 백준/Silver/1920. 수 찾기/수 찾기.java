import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int binarySearch(int[] arr, int key) {
        int lt = 0;
        int rt = arr.length - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(key < arr[mid]) {
                rt = mid-1;
            }
            else if(key > arr[mid]) {
                lt = mid+1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr1[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr1);
        int M = Integer.valueOf(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int key = Integer.valueOf(st.nextToken());
            if(binarySearch(arr1, key) >= 0)
                arr2[i] = 1;
            else
                arr2[i] = 0;
        }
        for(int i : arr2)
            System.out.println(i);
    }
}