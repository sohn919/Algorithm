import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.valueOf(br.readLine());
        Stack<Character> leftStk = new Stack<>();
        Stack<Character> rightStk = new Stack<>();
        for(char c : s.toCharArray())
            leftStk.add(c);

        while(N-- > 0) {
            String[] str = br.readLine().split(" ");
            switch (str[0]) {
                case "L":
                    if(!leftStk.isEmpty())
                        rightStk.add(leftStk.pop());
                    break;
                case "D":
                    if(!rightStk.isEmpty())
                        leftStk.add(rightStk.pop());
                    break;
                case "B":
                    if(!leftStk.isEmpty())
                        leftStk.pop();
                    break;
                case "P":
                    leftStk.add(str[1].charAt(0));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!leftStk.isEmpty()) {
            rightStk.push(leftStk.pop());
        }
        while(!rightStk.isEmpty()) {
            sb.append(rightStk.pop());
        }
        System.out.println(sb);
    }
}