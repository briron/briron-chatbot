package briron.brironchatbot;

import org.apache.commons.codec.binary.Base64;

import java.io.*;

public class FileToBinary {
    /**
     * 파일을 바이너리 스트링으로 변경
     *
     * @param file
     * @return
     */
    public static String fileToBinary(File file) {
        String out = "";
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Exception position : FileUtil - fileToString(File file)");
        }

        int len = 0;
        byte[] buf = new byte[1024];
        try {
            while ((len = fis.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }

            byte[] fileArray = baos.toByteArray();
            out = new String(base64Enc(fileArray));

            fis.close();
            baos.close();
        } catch (IOException e) {
            System.out.println("Exception position : FileUtil - fileToString(File file)");
        }

        return out;
    }

    public static byte[] base64Enc(byte[] buffer) {
        return Base64.encodeBase64(buffer);
    }

}
