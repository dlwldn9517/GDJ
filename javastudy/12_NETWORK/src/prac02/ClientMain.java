package prac02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {

		Socket socket = null;
		Scanner sc = null;
		BufferedWriter out = null;
		
		try {
			
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 9090));
			
			sc = new Scanner(System.in);
			
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			Client client = new Client(socket);
			client.start();
			
			while(true) {
				System.out.print(">>> ");
				String message = sc.nextLine();
				if(message.equalsIgnoreCase("exit")) {
					break;
				}
				out.write(message);
				out.flush();
				// flush() : 현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다.
				// 사용자가 원할 때 버퍼를 비워주는 것으로 버퍼를 비우는 것은 IO에서는 출력하는 것이다.
				// close()도 비슷하지만 닫아버리면 사용 불가
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null) {
					out.close();
				}
				if(socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
