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
	 * 打印結果
	 * @param b
	 */
	public void getResult(boolean b) {
		System.out.println("Bracket matching is " + b );
	}
	
	/**
	 * 檢查匹配
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
					if(stack.peek() == bracket.get(w)) { // peek() : 找stack最上層的值
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
