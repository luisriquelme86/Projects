import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpURLConnectionExample {

    public static void main(String[] args) throws Exception{

        /* Send a simple GET request
           You can send an HTTP request by just creating a URL object with the actual URL and then creating an HttpURLConnection from that. Btw,
           the actual request is not sent until you perform some operation e.g. reading a response code or reading data from InputStream.
        * */

        // URL url = new URL("https://www.google.com/search?q=pons");
        URL url = new URL("https://www.google.com/search?");
        // URL url = new URL("https://reqres.in/api/users?");
        // URL url = new URL("http://jsonplaceholder.typicode.com/posts?");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        // Es necesario, antes de eso devolvia 403
        // This tells us that the web server may return a 403 Forbidden HTTP status code in response to the request I made and indicates that the server can be reached
        // and understood the request, but refuses to take any further action. Status code 403 responses are the result of the web server being configured to deny access,
        // for some reason, to the requested resource by the client.
        // This led me to ask myself how can I make my request from Java more “browsery-like”. The first thing that comes to mind is trying to add an user agent to
        // the request just like the one in line 3 from the web browser request.
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("q", "pons");
        // parameters.put("page", "2");
        // parameters.put("userId", "1");
        // conn.setDoInput(true);
        // DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        // out.writeBytes(ParameterStringBuilder.getParamsString(parameters));

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.print("Response from " + url.toString() + ParameterStringBuilder.getParamsString(parameters) + " is " + responseCode + "\n");
            // System.out.print("Response from " + url.toString() + " is " + responseCode + "\n");

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                content.append(inputLine);
            }

            System.out.print("Content is " + content.toString());
            // out.flush();
            // out.close();
            in.close();
        }
        else {
            System.out.print("Get request not worked");
        }
    }
}

class ParameterStringBuilder {
    public static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry: params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }
        String resultString = result.toString();
        return resultString.length() > 0 ? resultString.substring(0, resultString.length() -1 ) : resultString;
    }
}
