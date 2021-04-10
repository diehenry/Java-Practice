package bm;

import java.util.HashMap;
import java.util.Stack;

public class BracketBean {

	private HashMap<Character,Character> bracket = new HashMap<Character,Character>();
	public BracketBean() {
		bracket.put(')', '(');
		bracket.put(']', '[');
		bracket.put('}', '{');
	}
	
	/**
	 * ���L���G
	 * @param b
	 */
	public void getResult(boolean b) {
		System.out.println("Bracket matching is " + b );
	}
	
	/**
	 * �ˬd�ǰt
	 * @param word
	 * @return stack.empty()
	 */
	public boolean isMatch(String word) {
		
		char[] wordChar = word.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(char w : wordChar) {
			if(bracket.containsValue(w)) {   // ( ,[ ,{
				stack.push(w);
			}else if(bracket.containsKey(w)){ // ) ,] ,}
				if(stack.empty()) {
					return false ;
				}else {
					if(stack.peek() == bracket.get(w)) { // peek() : ��stack�̤W�h����
						stack.pop();
					}else {
						return false ;
					}
				}
			}else {
				
			}

		}
		
		return stack.empty();	
	}


	
	

}
