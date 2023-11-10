import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        if (str1.equalsIgnoreCase(str2)) {
            return 65536;
        }
        // 2글자
        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();
        for (int i=0; i<str1.length()-1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i+1);
            if (Character.isAlphabetic(ch1) && Character.isAlphabetic(ch2)) {
                String str = ("" + ch1 + ch2).toLowerCase();
                str1Map.put(str, str1Map.getOrDefault(str, 0) + 1);
            }
        }
        for (int i=0; i<str2.length()-1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i+1);
            if (Character.isAlphabetic(ch1) && Character.isAlphabetic(ch2)) {
                String str = ("" + ch1 + ch2).toLowerCase();
                str2Map.put(str, str2Map.getOrDefault(str, 0) + 1);
            }
        }
        int union = 0;
        int inter = 0;
        for (String s : str1Map.keySet()) {
            if (str2Map.containsKey(s)) {
                int str1Cnt = str1Map.get(s);
                int str2Cnt = str2Map.get(s);
                union += Math.max(str1Cnt, str2Cnt);
                inter += Math.min(str1Cnt, str2Cnt);
                str2Map.remove(s);
            } else {
                union += str1Map.get(s);
            }
        }
        if (str2Map.size() > 0) {
            for (String s : str2Map.keySet()) {
                union += str2Map.get(s);
            }
        }
        System.out.print(inter + " " + union);
        return (int) (((float) inter / (float) union) * 65536);
    }
}