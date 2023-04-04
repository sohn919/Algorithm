import java.util.*;
class Solution {
    public int binarysearch(int[] arr, int n) {
        int lt = 0;
        int rt = arr.length - 1;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] > n) {
                rt = mid - 1;
            }
            else if(arr[mid] < n) {
                lt = mid + 1;
            }
            else {
                return 1;
            }
        }
        return 0;
    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] arr = {6, 6, 5, 4, 3, 2, 1};
        Arrays.sort(win_nums);
        int cnt = 0;
        int zero = 0;
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) {
                zero++;
                continue;
            }
            cnt += binarysearch(win_nums, lottos[i]);
        }
        answer[0] = arr[cnt + zero];
        answer[1] = arr[cnt];
        return answer;
    }
}