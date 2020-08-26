package briron.brironchatbot;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Collections;

@Service
public class OrmService {

    @Autowired
    RestTemplate restTemplate;

    public String ormRequest(File file) throws IOException{
        String API_URL = "https://dapi.kakao.com/v2/vision/text/ocr";
        HttpHeaders headers = new HttpHeaders();
        BufferedReader br = new BufferedReader(new FileReader("../../resources/kakao.json"));
        String kakaoKey = br.readLine();

        byte[] fileData = new byte[(int)file.length()];
        FileInputStream in = new FileInputStream(file);
        in.read(fileData);
        in.close();

        headers.set("Authorization", String.format("KakaoAK %s", kakaoKey);
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();

        params.add("image", fileData)

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);


        ResponseEntity<String> responseEntity = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, String.class);
        


    }


}
