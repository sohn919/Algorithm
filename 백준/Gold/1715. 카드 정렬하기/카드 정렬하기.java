import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    PriorityQueue<Integer> pQ = new PriorityQueue<>();
    for(int i=0; i<N; i++) {
      int a = sc.nextInt();
      pQ.add(a);
    }
    int sum = 0;
    while(pQ.size() != 1) {
      int data1 = pQ.poll();
      int data2 = pQ.poll();
      sum += data1 + data2;
      pQ.add(data1 + data2);
    }

    System.out.print(sum);
  }
}