class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n);
        char[] chr = str.toCharArray();
        for(int i=0; i<chr.length; i++) {
            answer += chr[i] - '0';
        }
        return answer;
    }
}