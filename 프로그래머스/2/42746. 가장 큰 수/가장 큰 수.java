import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.charAt(0) != o2.charAt(0)) {
                return o1.charAt(0) - o2.charAt(0);
            } else if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });
        for (int i=arr.length-1; i>=0; i--) {
           answer += arr[i]; 
        }
        if (answer.charAt(0) == '0')
            return "0";
        return answer;
    }
}