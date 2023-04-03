import java.util.HashMap;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> Hmap = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            Hmap.put(name[i], yearning[i]);
        }
        for(int i=0; i<photo.length; i++) {
            int sum = 0;
            for(int j=0; j<photo[i].length; j++) {
                if(Hmap.get(photo[i][j]) == null) {
                    continue;
                }
                else {
                    sum += Hmap.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}