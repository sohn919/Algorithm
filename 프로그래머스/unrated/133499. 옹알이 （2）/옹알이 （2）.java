class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0; i<babbling.length; i++) {
            String str = babbling[i];
            str = str.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            str = str.replaceAll("aya|ye|woo|ma", "");
            answer += str.length() == 0 ? 1 : 0;
        }
        return answer;
    }
}