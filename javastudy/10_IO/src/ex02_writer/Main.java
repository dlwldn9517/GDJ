package ex02_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void m1() {
		
		File dir = new File("C:\\storage");
		
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "m1.txt");
		
		FileWriter fw = null;
		try {
			// C:\\storage\\m1.txt 파일과 연결되는 문자 출력 스트림 생성
			// 출력 스트림이 생성되면 파일도 언제나 생성됨 (원래 있던 파일 지우고 언제나 새로 생성)
			fw = new FileWriter(file);	// new FileWriter("C:\\storage\\m1.txt")와 같음
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		m1();
	}

}
