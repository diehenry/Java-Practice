package socket;
import java.io.*;
import java.net.*;
import java.util.Date;
public class MyServer {

	String msg = "Client �s�u���\ "+new Date() ;
	String waitMsg = "waiting ... ..." ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer server = new MyServer();
		server.go();
	}
	public void go() {
		try {
			// �غc���A����port:8888�����f
			ServerSocket serverSock = new ServerSocket(8888);
			while(true) {
				System.out.println(waitMsg);
				// �غc�P�Τ�ݳq�T��socket(�|�t�~�ͦ��sport,�D8888) /  accept():�|�@������client�s�W
				Socket s = serverSock.accept();
				// PrintWriter : ��socket�n��X���줸���ഫ���r��
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
