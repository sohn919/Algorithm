import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i=0; i<3; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            sb.append(arr[c - 'A'] + " ");
        }
        System.out.print(sb);
    }
}