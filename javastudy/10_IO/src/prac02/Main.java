package prac02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

	public static void q1() {
		
		// eclipse-jee-2021-03-R-win32-x86_64.zip 복사하기
		// 복사할 파일명은 eclipse.zip
	
		File src = new File("C:\\GDJ\\installer", "eclipse-jee-2021-03-R-win32-x86_64.zip");
		File cpy = new File("C:\\GDJ\\installer", "eclipse.zip");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
				
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(cpy));
			
			byte[] b = new byte[1024];	// 1KB
			int readByte = 0;
			
			while((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			if(bos != null) bos.close();
			if(bis != null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}

		
	public static void main(String[] args) {
		q1();
	}

}
