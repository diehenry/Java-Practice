package socket;
import java.io.*;
import java.net.*;


public class MyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient client = new MyClient();
		client.go();
	}

	public void go() {

		try {
			// 建立連接伺服器的ip & port 
			Socket socket = new Socket("127.0.0.1",8888);
			
			/* **********************************************************
			 * 宣告一個暫存來存放伺服器的資料 
			 * socket.getInputStream() : 從伺服器讀入的位元組 ex 010010
			 * InputStreamReader : 將位元組轉換成字元 ex 010010-> Hi
			 * BufferedReader : 使用暫存鏈結到InputStreamReader，來取得字元
			 *************************************************************/
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			System.out.println("From Server's msg is: "+line);
			reader.close();
			socket.close();
			
			

		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
