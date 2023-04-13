import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> hmap = new HashMap<>();
        HashMap<String, Integer> userReport = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            hmap.put(id_list[i], new HashSet<>());
        }
        for(int i=0; i< report.length; i++) {
            String[] str = report[i].split(" ");
            HashSet temp = hmap.get(str[0]);
            int size = temp.size();
            temp.add(str[1]);
            if(size != temp.size()) {
                userReport.put(str[1], userReport.getOrDefault(str[1], 0) + 1);
            }
            hmap.put(str[0], temp);
        }
        ArrayList<String> arr = new ArrayList<>();
        for(String s : userReport.keySet()) {
            if(userReport.get(s) >= k) {
                arr.add(s);
            }
        }
        for(String s : arr) {
            for(int i=0; i<hmap.size(); i++) {
                HashSet set = hmap.get(id_list[i]);
                if(set.contains(s))
                    answer[i]++;
            }
        }
        return answer;
    }
}