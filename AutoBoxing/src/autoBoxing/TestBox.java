package autoBoxing;

public class TestBox {
	
	//Integer i ;
	Integer i =  0 ;
	int j ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBox t = new TestBox();
		t.go();
	}
	
	public void go() {
		j = i ;
		i++ ;
		System.out.println("int:"+j);
		System.out.println("Integer:"+i);
	}

}
