package bm;
/**
 * 
 * @author umr
 * ToDo "BracketMatching"
 */
public class BracketMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BracketBean bb = new BracketBean();
		bb.getResult(bb.isMatch("()([789-]{})"));
		bb.getResult(bb.isMatch("(]{})"));
		bb.getResult(bb.isMatch("{[]({})}"));
	}

}
