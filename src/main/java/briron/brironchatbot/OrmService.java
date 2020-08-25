package briron.brironchatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class OrmService {

    @Autowired
    RestTemplate restTemplate;

    public static String fileToBinary(File file) {
        String out = new String();
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Exception position : FileUtil - fileToString(File file)");
            return out;
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
            return out;
        }

        return out;
    }


    public String request(File file){
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Exception position : FileUtil - fileToString(File file)");
        }

    }

    String JsonStr = restTemplate.getForObject("", String.class)

}
