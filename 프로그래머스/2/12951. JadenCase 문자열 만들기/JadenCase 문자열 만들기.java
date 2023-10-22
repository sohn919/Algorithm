import java.util.StringTokenizer;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ", true);
        while (st.hasMoreTokens()) {
            String s1 = st.nextToken();
            if (s1.equals(" ")) {
                answer += " ";
            } else {
                answer += s1.substring(0, 1).toUpperCase() + s1.substring(1).toLowerCase();
            }
        }
        return answer;
    }
}