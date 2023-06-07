import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> RStack = new Stack<>();
        Stack<Character> KStack = new Stack<>();
        int answer = 0;
        boolean flag = false;
        for(char ch : br.readLine().toCharArray()) {
            if(flag) break;
            if(Character.isDigit(ch)) answer++;
            else {
                switch (ch) {
                    case 'S' : KStack.push(ch); break;
                    case 'L' : RStack.push(ch); break;
                    case 'R' :
                        if(!RStack.isEmpty()) {
                            RStack.pop();
                            answer++;
                        } else flag = true;
                        break;
                    case 'K' :
                        if(!KStack.isEmpty()) {
                            KStack.pop();
                            answer++;
                        } else flag = true;
                        break;
                }
            }
        }
        System.out.print(answer);
    }
}