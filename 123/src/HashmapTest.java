import java.util.HashMap;
import java.util.Map;
public class HashmapTest{
	/*
	 * 找arr陣列中兩數字相加為target
	 * Ex: arr[2]+arr[3] = 17 
	 * 回傳陣列位置 2, 3
	 * */
	public static void main(String[] args) {
		int arr[] = {2,5,7,10};
		int target = 17 ;
		HashmapTest hashmaptest = new HashmapTest();
		int hashmaptestArray[] = hashmaptest.twoSum(arr, target) ;
		for(int e : hashmaptestArray) {
			System.out.println("得到: " +e);	
		}
		
	}
	// map{key,value} = {17-2,0} , {17-5,1} ,{17-7,2} ..
	public int[] twoSum(int[] numbers , int target) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int[] result = new int[2];

	    for (int i = 0; i < numbers.length; i++) {
	    	// i=3 , key = numbers[3] = 10  , index = 2 
	        if (map.containsKey(numbers[i])) {
	            int index = map.get(numbers[i]);
	            result[0] = index ;
	            result[1] = index+1;
	            break;
	        } else {
	            map.put(target - numbers[i], i);
	        }
	    }

	    return result;
	    
	}
}