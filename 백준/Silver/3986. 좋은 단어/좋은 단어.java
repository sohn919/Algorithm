import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<N; i++) {
            Stack<Character> stack = new Stack<>();
            char[] ch = br.readLine().toCharArray();
            for(int j=0; j<ch.length; j++) {
                if (!stack.isEmpty() && stack.peek() == ch[j]) {
                    stack.pop();
                } else {
                    stack.push(ch[j]);
                }
            }
            if(stack.isEmpty())
                answer++;
        }
        System.out.print(answer);
    }
}