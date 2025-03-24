import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++) {
        	if(!st.isEmpty() && st.getLast() == arr[i])
        		continue;
        	st.add(arr[i]);
        }
        answer = new int[st.size()];
        int i = 0;
        while(!st.isEmpty()) {
        	answer[i++] = st.pollFirst();
        }
        return answer;
    }
}