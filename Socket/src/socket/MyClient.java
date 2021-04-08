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
			// �إ߳s�����A����ip & port 
			Socket socket = new Socket("127.0.0.1",8888);
			
			/* **********************************************************
			 * �ŧi�@�ӼȦs�Ӧs����A������� 
			 * socket.getInputStream() : �q���A��Ū�J���줸�� ex 010010
			 * InputStreamReader : �N�줸���ഫ���r�� ex 010010-> Hi
			 * BufferedReader : �ϥμȦs�쵲��InputStreamReader�A�Ө��o�r��
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
