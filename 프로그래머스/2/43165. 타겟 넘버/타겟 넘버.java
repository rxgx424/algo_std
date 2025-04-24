import java.util.*;
import java.io.*;
class Solution {
    int src[];
    int ans = 0;
    int cnt = 0;
    
    public int solution(int[] numbers, int target) {
               
        src = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            src[i] = numbers[i];
        }
        comb(src, 0, target);
        return cnt;
    }
    
    public void comb(int src[], int idx, int target){
        if(idx == src.length){
            for(int i = 0; i < src.length; i++){
                ans+=src[i];
            }
            if(ans == target) cnt++;
            // System.out.println(Arrays.toString(src));
            ans = 0;
            return;
        }
        
        src[idx] *= -1;
        comb(src, idx+1, target);
        
        src[idx] *= -1;
        comb(src, idx+1, target);
    }
}