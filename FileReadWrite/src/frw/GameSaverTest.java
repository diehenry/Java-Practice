package frw;
import java.io.*;
import java.util.ArrayList;
public class GameSaverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow","sword","dust"} );
		GameCharacter two = new GameCharacter(200, "Troll", new String[] {"ax"} );
		GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells","invisibility"} );
		String fileName_Object = "GameCharacter_Object.txt" ;
		String fileName_String = "GameCharacter_String.txt" ;
		
		// ==========  序列化 與 反序列化 讀寫  START ==============
		// Write out to GameCharacter_Object.txt
		try {
			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\umr\\Desktop\\"+fileName_Object));
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	/*
		one = null ;
		two = null ; 
		three = null ;
	*/
		// Read in from GameCharacter_Object.txt
		try {
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\umr\\Desktop\\"+fileName_Object)) ;
			ObjectInputStream is = new ObjectInputStream(fis) ;
			GameCharacter oneRestore =  (GameCharacter) is.readObject() ;
			GameCharacter twoRestore =  (GameCharacter) is.readObject() ;
			GameCharacter threeRestore =  (GameCharacter) is.readObject() ;
			
			is.close();
			
			ArrayList<GameCharacter> al_gc = new ArrayList<GameCharacter>();
			al_gc.add(oneRestore);
			al_gc.add(twoRestore);
			al_gc.add(threeRestore);
			System.out.println("Show GameCharacter_Object.txt ...");
			for(GameCharacter gc : al_gc ) {
				System.out.println("Type:"+gc.getType()+"  power:"+gc.getPower()+"  weapons:"+gc.getWeapons());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// ==========  序列化 與 反序列化 讀寫  END ==============
		
		// ==========  文字檔案 讀寫  START =====================
		// Write out to GameCharacter_String.txt
		try {
			File file = new File("C:\\Users\\umr\\Desktop\\" + fileName_String);
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(one.getPower() + "," + one.getType() + "," + one.getWeapons() + "\n");
			writer.write(two.getPower() + "," + two.getType() + "," + two.getWeapons() + "\n");
			writer.write(three.getPower() + "," + three.getType() + "," + three.getWeapons() + "\n");
			writer.flush(); // 強制buffer立即寫入
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		// Read in from GameCharacter_String.txt
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(new File("C:\\Users\\umr\\Desktop\\" + fileName_String)));
			// 用 line 變數 來承接讀取結果
			String line = null;   
			System.out.println("\nRead GameCharacter_String.txt ...");
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		// ==========  文字檔案 讀寫  END =======================
		
	}

}
