import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Map<Integer, Point> phone = new HashMap<>();
        int cnt = 1;
        for(int i=1; i<=3; i++) {
            for(int j=1; j<=3; j++) {
                phone.put(cnt++, new Point(i, j));
            }
        }
        phone.put(0, new Point(4, 2));
        Point left = new Point(4, 1);
        Point right = new Point(4, 3);
        for(int i=0; i<numbers.length; i++) {
            int temp = numbers[i];
            switch (temp) {
                case 1, 4, 7 :
                    answer += "L";
                    left = phone.get(temp);
                    break;
                case 3, 6, 9 :
                    answer += "R";
                    right = phone.get(temp);
                    break;
                default:
                    int leftDis = Point.dis(left, phone.get(temp));
                    int rightDis = Point.dis(right, phone.get(temp));
                    if(leftDis > rightDis) {
                        answer += "R";
                        right = phone.get(temp);
                    } else if(leftDis < rightDis) {
                        answer += "L";
                        left = phone.get(temp);
                    } else {
                        if(hand.equals("right")) {
                            answer += "R";
                            right = phone.get(temp);
                        } else {
                            answer += "L";
                            left = phone.get(temp);
                        }
                    }
                    break;
            }
        }
        return answer;
    }
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public static int dis(Point o1, Point o2) {
            return Math.abs(o1.x - o2.x) + Math.abs(o1.y - o2.y);
        }
    }
}