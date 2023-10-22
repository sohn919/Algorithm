import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;
        if (n == 1 || n == 2) {
            return 1;
        }
        while (n > 2) {
            if (n % 2 == 1) {
                ans++;
            }
            n /= 2;
        }
        return ans;
    }
}