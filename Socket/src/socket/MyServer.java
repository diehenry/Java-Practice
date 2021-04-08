package socket;
import java.io.*;
import java.net.*;
import java.util.Date;
public class MyServer {

	String msg = "Client 連線成功 "+new Date() ;
	String waitMsg = "waiting ... ..." ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer server = new MyServer();
		server.go();
	}
	public void go() {
		try {
			// 建構伺服器對port:8888的窗口
			ServerSocket serverSock = new ServerSocket(8888);
			while(true) {
				System.out.println(waitMsg);
				// 建構與用戶端通訊的socket(會另外生成新port,非8888) /  accept():會一直等待client連上
				Socket s = serverSock.accept();
				// PrintWriter : 把socket要輸出的位元組轉換成字串
				PrintWriter writer  = new PrintWriter(s.getOutputStream());
				writer.println(msg);
				writer.close();
				s.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
