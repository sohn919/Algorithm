class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int remove = 0;
        String str = s;
        if (s.length() == 0) return new int[] {0, 0};
        while (true) {
            cnt++;
            int temp = str.length();
            str = str.replaceAll("0", "");
            remove += temp - str.length();
            if (str.length() == 1) {
                answer[0] = cnt;
                answer[1] = remove;
                break;
            } else {
                str = Integer.toString(str.length(), 2);
            }
        }
        return answer;
    }
}