import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> jh = new HashMap<>();
        for (int i = 0; i < discount.length; i++) {
            init(want,number,jh);
			for(int j = 0; j < 10 ;j++) {
				if(discount.length<=i+j) break;
				if( jh.containsKey(discount[i+j]) ) {
					jh.put(discount[i+j], jh.get(discount[i+j])-1);
					if(jh.get(discount[i+j])<=0) jh.remove(discount[i+j]);
				}
				else break;
			}
			if(jh.size() == 0) answer++;
		}
        return answer;
    }
	static void init(String[] want, int[] number, HashMap<String, Integer> hash) {
		for(int i = 0; i < want.length; i++) {
        	hash.put(want[i], number[i]);
        }
	}
}