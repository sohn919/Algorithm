import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i=0; i<record.length; i++) {
            String[] str = record[i].split(" ");
            if (!str[0].equals("Leave")) {
                map.put(str[1], str[2]);
            }
        }
        for (int i=0; i<record.length; i++) {
            String[] str = record[i].split(" ");
            if (str[0].equals("Enter")) {
                answer.add(map.get(str[1]) + "님이 들어왔습니다.");
            } else if (str[0].equals("Leave")) {
                answer.add(map.get(str[1]) + "님이 나갔습니다.");
            }
        }
        return answer.toArray(new String[answer.size()]);
    }
}