import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] dx = {{0, 0}, {0, 0}, {1, 2}, {-1, 3}};
    static int[][] dy = {{1, 0}, {-1, 1}, {0, 0}, {0, 0}};
    static int answer = Integer.MAX_VALUE;

    public static int solution(int[][] board) {
        BFS(board);
        return answer;
    }

    // 동 서 남 북 0, 1, 2, 3
    public static void BFS(int[][] board) {
        boolean[][][] visited = new boolean[4][board.length][board.length];
        int[][] costBoard = new int[board.length][board.length];
        for (int i=0; i<costBoard.length; i++) {
            for (int j=0; j<costBoard.length; j++) {
                costBoard[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Car> cars = new LinkedList<>();
        Car car = new Car(0, 0, -1, 0);
        cars.add(car);
        while(!cars.isEmpty()) {
            Car curCar = cars.poll();
            if (curCar.x == board.length - 1 && curCar.y == board.length - 1) {
                answer = Math.min(answer, curCar.cost);
            }
            for (int i=0; i<4; i++) {
                int nx = curCar.x + dx[i][0];
                int ny = curCar.y + dy[i][0];
                int nDir = dx[i][1] + dy[i][1];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    continue;
                }
                if (curCar.dir == -1 || curCar.dir == nDir) {
                    if (!visited[nDir][nx][ny] || costBoard[nx][ny] >= curCar.cost + 100) {
                        cars.add(new Car(nx, ny, nDir, curCar.cost + 100));
                        visited[nDir][nx][ny] = true;
                        costBoard[nx][ny] = curCar.cost + 100;
                    }
                } else {
                    if (!visited[nDir][nx][ny] || costBoard[nx][ny] >= curCar.cost + 600) {
                        cars.add(new Car(nx, ny, nDir, curCar.cost + 600));
                        visited[nDir][nx][ny] = true;
                        costBoard[nx][ny] = curCar.cost + 600;
                    }
                }
            }
        }
    }

}

class Car {
    int x, y;
    int dir;
    int cost;

    public Car(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}