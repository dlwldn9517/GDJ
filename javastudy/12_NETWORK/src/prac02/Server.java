package prac02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Server extends Thread {

	private Socket client;
	private BufferedReader in;
	private BufferedWriter out;

	public Server(Socket client) {
		
		try {
			this.client = client;
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
											// ServerMain 클래스의 sendMessage() 메소드로 던지고,
	public void sendMessage(String message) throws IOException {
		out.write(message);
		out.flush();
	}
	
	
	@Override
	public void run() {
		
		try {
			String message = null;
			while(true) {
				message = in.readLine();
				if(message.equalsIgnoreCase("exit")) {	// 채팅창에 exit 입력하면 채팅 종료
					break;
				}
				// 모든 클라이언트에게 메시지 출력
				InetSocketAddress address = (InetSocketAddress)client.getRemoteSocketAddress();
				ServerMain.sendMessage(address.getHostName() + "의 메시지 : " + message);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
