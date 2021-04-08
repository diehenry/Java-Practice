package collections;
import java.util.*; 
import java.io.*; 

public class CollectionsTest {

	public static void main(String[] args) {
		ArrayList<Book> list3 = new ArrayList<Book>();
		list3.add(new Book(2348, "Gogogo", "computer"));
		list3.add(new Book(1698, "Happy", "art"));
		list3.add(new Book(5468, "Martin", "music"));

		System.out.println("Unsorted");
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i));
		}
	
		Collections.sort(list3, new BookSort());

		System.out.println("\nBook Sort");
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i));
		}	
	}

}
// 一個Book的類 
class Book 
{ 
	int bookID; 
	String name, type; 

	// Constructor 
	public Book (int bookID, String name, 
							String type) 
	{ 
		this.bookID = bookID; 
		this.name = name; 
		this.type = type; 
	} 

	// Book的資料
	public String toString() 
	{ 
		return this.bookID + " " + this.name + 
						" " + this. type; 
	} 
} 

class BookSort implements Comparator<Book> 
{ 
	//以book的ID升序排列
	public int compare(Book a, Book b) 
	{ 
		return a.bookID - b.bookID; 
	} 
} 
