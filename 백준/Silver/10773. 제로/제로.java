import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) {
                if(!stack.isEmpty()) {
                    sum -= stack.pop();
                }
            }
            else {
                stack.add(temp);
                sum += temp;
            }
        }
        System.out.print(sum);
    }
}