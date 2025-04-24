import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        PriorityQueue<Integer> lostQ = new PriorityQueue<>();
        PriorityQueue<Integer> reserveQ = new PriorityQueue<>();
        
        for(int i = 0; i < lost.length; i++){
            lostQ.add(lost[i]);
        }
        for(int i = 0; i < reserve.length; i++){
            reserveQ.add(reserve[i]);
        }
        
        while( !reserveQ.isEmpty() ){
            int num = reserveQ.poll();
            if( lostQ.isEmpty() ) {
                break;
            }
            
            if(lostQ.contains(num)) {
                lostQ.remove(num);
                continue;
            }
            
            for(int i = num -1; i <= num +1; i++){
                if(lostQ.contains(i)){
                    if(reserveQ.contains(i)) {
                        reserveQ.remove(i);
                        lostQ.remove(i);
                    } else{
                        lostQ.remove(i);
                        break;
                    }
                }
            }
        }
        
        return answer -= lostQ.size();
    }
}