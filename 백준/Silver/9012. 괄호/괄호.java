import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            String s = br.readLine();
            if(s.length() % 2 == 1) {
                sb.append("NO\n");
                continue;
            }
            sb.append(solution(s) + "\n");
        }
        System.out.print(sb);
    }

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == ')') {
                if(stack.isEmpty())
                    return "NO";
                else
                    stack.pop();
                continue;
            }
            stack.push('(');
        }
        if(stack.isEmpty())
            return "YES";
        else
            return "NO";
    }
}