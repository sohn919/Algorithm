import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        ArrayList<Integer> arr2 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<8; i++) {
            arr2.add(Integer.parseInt(st.nextToken()));
        }
        if(arr.equals(arr2)) {
            System.out.print("ascending");
            return;
        }
        Collections.sort(arr, Collections.reverseOrder());
        if(arr.equals(arr2)) {
            System.out.print("descending");
            return;
        }
        System.out.print("mixed");
    }
}