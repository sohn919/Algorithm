import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> color = colorInit(new HashMap<>());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        for(int i=0; i<2; i++) {
            str += color.get(br.readLine());
        }
        int num = color.get(br.readLine());
        long temp = Integer.parseInt(str);
        long answer = temp * (long)Math.pow(10, num);
        System.out.println(answer);
    }

    public static Map<String, Integer> colorInit(Map<String, Integer> color) {
        color.put("black", 0);
        color.put("brown", 1);
        color.put("red", 2);
        color.put("orange", 3);
        color.put("yellow", 4);
        color.put("green", 5);
        color.put("blue", 6);
        color.put("violet", 7);
        color.put("grey", 8);
        color.put("white", 9);

        return color;
    }
}
