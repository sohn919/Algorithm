class Solution {
    
    static char[] ch = {'A', 'E', 'I', 'O', 'U'};
    static int answer = 0;
    static int cnt = 0;
    
    public int solution(String word) {
        dfs("", word);
        
        return answer;
    }
    
    public void dfs(String str, String word) {
        if (str.equals(word)) {
            answer = cnt;
        }
        if (str.length() >= 5) {
            return;
        }
        for (int i=0; i<5; i++) {
            cnt++;
            dfs(str + ch[i], word);
        }
    }
}