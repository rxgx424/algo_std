package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_기능개발 {

	public static void main(String[] args) {
		int[] pro= {95, 94, 93};
		int[] sp= {3, 3, 3};
		System.out.println(solution(pro,sp));
	}
	
	public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int day = (int) Math.ceil((100-progresses[0])/(speeds[0]*1.0));;
        int count = 1;
        
        for(int i = 1; i < progresses.length ; i++) {
        	if(day>=Math.ceil((100-progresses[i])/(speeds[i]*1.0))) {
        		count++;
        	}
        	else {
        		result.add(count);
        		day=(int) Math.ceil((100-progresses[i])/(speeds[i]*1.0));
        		count=1;
        	}
        }
		result.add(count);
        return result;
    }
}
