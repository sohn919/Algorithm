import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = 0;
        while (n++ < s.length()) {
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int i=0; i<s.length(); i++) {
                if (closeChar(s.charAt(i))) {
                    if (stack.isEmpty() || !equalsOpenChar(stack.peek(), s.charAt(i))) {
                        flag = true;
                        break;
                    }
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            if (stack.isEmpty() && !flag) {
                answer++;
            }
            s = s.substring(1) + s.substring(0, 1);
        }
        return answer;
    }

    public boolean closeChar(Character ch) {
        if (ch == ')') {
            return true;
        }
        if (ch == '}') {
            return true;
        }
        if (ch == ']') {
            return true;
        }
        return false;
    }
    
    public boolean equalsOpenChar(Character ch1, Character ch2) {
        if (ch1 == '(' && ch2 == ')') {
            return true;
        }
        if (ch1 == '{' && ch2 == '}') {
            return true;
        }
        if (ch1 == '[' && ch2 == ']') {
            return true;
        }
        return false;
    }
}