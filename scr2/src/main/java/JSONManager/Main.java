package JSONManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class Main {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet("https://swapi.dev/api/people");
            CloseableHttpResponse response = httpClient.execute(request);
            try {
                System.out.println("Hola mundo");
                System.out.println(response.getProtocolVersion());              // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    var result = EntityUtils.toString(entity);
                    ApiResponse<Character> listapersonajes= mapper.readValue(
                            result, mapper.getTypeFactory().constructParametricType(ApiResponse.class, Character.class));
                    List<Character> listacaracteres = listapersonajes.getResults();
                    for (Character personaje: listacaracteres){
                        System.out.println("El personaje "+personaje.getName()+" mide "+personaje.getHeight()+" y nació en "+personaje.getBirth_year());

                    }



                }
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }
}
