package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExam {
    public static void main(String[] args) throws Exception {
        String originalFileName = "C:/Temp/vi.txt";
        String targetFileName = "C:/Temp/vi2.txt";

        InputStream is = new FileInputStream(originalFileName);
        OutputStream os = new FileOutputStream(targetFileName);

		byte[] data = new byte[1024];/*얼마나 조각을 잘라서 옮길 것 인가?*/
		while(true) {
			int num = is.read(data);
			if(num == -1) break;
			os.write(data, 0, num);
		}

        is.transferTo(os);

        os.flush();
        os.close();
        is.close();

        System.out.println("복사가 잘 되었습니다.");
    }
}

