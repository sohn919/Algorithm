class Solution {
    public int solution(String dirs) {
        int answer = 0;
        // 상, 하, 좌, 우
        boolean[][][] visited = new boolean[4][11][11];
        int x = 0, y = 0;
        for (int i=0; i<dirs.length(); i++) {
            char dir = dirs.charAt(i);
            if (dir == 'U' && y+1 <= 5) {
                if (!visited[0][x+5][y+1+5] && !visited[1][x+5][y+5]) {
                    answer++;
                }
                visited[0][x+5][y+1+5] = true;
                visited[1][x+5][y+5] = true;
                y+=1;
            } else if (dir == 'D' && y-1 >= -5) {
                if (!visited[1][x+5][y-1+5] && !visited[0][x+5][y+5]) {
                    answer++;
                }
                visited[1][x+5][y-1+5] = true;
                visited[0][x+5][y+5] = true;
                y-=1;
            } else if (dir == 'R' && x+1 <= 5) {
                if (!visited[2][x+1+5][y+5] && !visited[3][x+5][y+5]) {
                    answer++;
                }
                visited[2][x+1+5][y+5] = true;
                visited[3][x+5][y+5] = true;
                x+=1;
            } else if (dir == 'L' && x-1 >= -5) {
                if (!visited[3][x-1+5][y+5] && !visited[2][x+5][y+5]) {
                    answer++;
                }
                visited[3][x-1+5][y+5] = true;
                visited[2][x+5][y+5] = true;
                x-=1;
            }
        }
        return answer;
    }
}