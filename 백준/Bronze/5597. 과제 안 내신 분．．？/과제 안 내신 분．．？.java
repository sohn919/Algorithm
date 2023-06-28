import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] student = new int[31];
        for(int i=1; i<29; i++) {
            int success = Integer.parseInt(br.readLine());
            student[success] = 1;
        }
        for(int i=1; i<student.length; i++) {
            if(student[i] != 1)
                System.out.println(i);
        }
    }
}
