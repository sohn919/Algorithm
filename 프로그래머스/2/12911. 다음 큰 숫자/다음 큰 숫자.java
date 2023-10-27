class Solution {
    public int solution(int n) {
        int answer = 0;
        String cur = Integer.toString(n, 2);
        int len = 0;
        for (int i=0; i<cur.length(); i++) {
            if (cur.charAt(i) == '1')
                len++;
        }
        while (true) {
            n++;
            String curStr = Integer.toString(n, 2);
            int curLen = 0;
            for (int i=0; i<curStr.length(); i++) {
                if (curStr.charAt(i) == '1') 
                    curLen++;
            }
            if (len == curLen) {
                break;
            }
        }
        return answer = n;
    }
}