import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] block = new char[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                block[i][j] = board[i].charAt(j);
            }
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            boolean[][] visited = new boolean[m][n];
            for (int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    char ch = block[i][j];
                    if (ch == '0') continue;
                    if (!('A' <= ch && 'Z' >= ch)) continue;
                    if (ch == block[i+1][j] && ch == block[i][j+1] && ch == block[i+1][j+1]) {
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            for (int i=m-1; i>=0; i--) {
                for (int j=0; j<n; j++) {
                    if (visited[i][j]) {
                        block[i][j] = '0';
                        for (int k=i-1; k>=0; k--) {
                            if (!visited[k][j] && block[k][j] != '0') {
                                visited[k][j] = true;
                                block[i][j] = block[k][j];
                                block[k][j] = '0';
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (block[i][j] == '0') answer++;
            }
        }
        return answer;
    }
}