package ch18.sec07;

import java.io.*;

public class burfferExam {
    public static void main(String[] args) throws Exception {
        String originalFilepath1=
                burfferExam.class.getResource("originalFile1.jpg").getPath();
        FileInputStream fis = new FileInputStream(originalFilepath1);
        String targetFilepath1="c:/Temp/targetFile1.jpg";
        FileOutputStream fos = new FileOutputStream(targetFilepath1);

        String originalFilepath2=
                burfferExam.class.getResource("originalFile2.jpg").getPath();
        FileInputStream fis2 = new FileInputStream(originalFilepath2);
        String targetFilepath2="c:/Temp/targetFile2.jpg";
        FileOutputStream fos2 = new FileOutputStream(targetFilepath2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos= new BufferedOutputStream(fos2);

        long nonBufferTime = copy(fis, fos);
        System.out.println("버퍼 미사용:\t" + nonBufferTime + " ns");
        long bufferTime = copy(bis, bos);
        System.out.println("버퍼 사용:\t" + bufferTime + " ns");
        fis.close();
        fos.close();
        bis.close();
        bos.close();
    }

    public static long copy(InputStream is, OutputStream os) throws Exception {
        long start = System.nanoTime();

        while(true) {
            int data = is.read();
            if (data == -1) {
                os.flush();
                long end = System.nanoTime();
                return end - start;
            }

            os.write(data);
        }
    }
}