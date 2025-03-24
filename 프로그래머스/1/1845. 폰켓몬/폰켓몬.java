import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        HashMap<Integer,Integer> mon = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	if(mon.containsKey(nums[i])) {
        		mon.put(nums[i],mon.get(nums[i])+1);
        	}
        	else {
        		mon.put(nums[i], 1);
        	}
        }
        if(mon.size()>answer)
        	return answer;
        else 
        	return mon.size();
    }
}