package programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution_괄호회전하기 {

	public static void main(String[] args) {
		String str = "}}}";
		System.out.println(solution(str));
	}
	
	public static int solution(String s) {
        int answer = 0;
        int len = s.length();
        Queue<Character> bracket = new ArrayDeque<>();
        Deque<Character> chkBr = new ArrayDeque<>();
        for( int i = 0; i < len; i++) {
        	bracket.add(s.charAt(i));
        }
        
        for(int i = 0; i < len; i++) {
        	chkBr.clear();
        	for (int j = 0; j < len; j++) {
				char ch = bracket.poll();
				if(ch == '(' || ch == '[' || ch == '{') {
					chkBr.add(ch);
				}
				else {
					if(!chkBr.isEmpty()) {
						char pk = chkBr.peekLast();
						if((pk == '(' && ch == ')') || (pk == '[' && ch == ']') || (pk == '{' && ch == '}') )
							chkBr.pollLast();
					}
					else chkBr.add('?');
				}
	        	bracket.add(ch);
			}
        	if(chkBr.isEmpty()) answer++;
        	bracket.add(bracket.poll());
        }
        return answer;
    }
}
