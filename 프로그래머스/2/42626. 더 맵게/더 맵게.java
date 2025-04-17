import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> sc = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            sc.add(scoville[i]);
        }
        int mix = 0;
        while( !sc.isEmpty() ) {
            int n1 = sc.poll();
            if( n1 >= K) {
                return answer;
            }
            if(sc.isEmpty()) break;
            int n2 = sc.poll();
            mix = n1 + (n2 * 2);
            answer++;
            sc.add(mix);
        }
        return -1;
    }
}