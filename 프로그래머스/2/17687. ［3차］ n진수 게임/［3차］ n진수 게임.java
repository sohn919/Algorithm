class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = " ";
        int idx = 0;
        while (str.length() < p + (m*t) + 1) {
            str += Integer.toString(idx, n).toUpperCase();
            idx++;
        }
        // System.out.print(str);
        answer += str.charAt(p);
        for (int i=1; i<t; i++) {
            // System.out.println(p+(m*i));
            answer += str.charAt(p+(m*i));
        }
        return answer;
    }
}