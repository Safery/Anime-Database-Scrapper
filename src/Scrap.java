import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Scrap {
	protected String getContent(int id){
		String returnContent = "";
        try {
            URL google = new URL("http://hummingbird.me/api/v1/anime/" + id);
            BufferedReader in = new BufferedReader(new InputStreamReader(google.openStream()));
            String inputLine; 
 
            while ((inputLine = in.readLine()) != null) {
                // Process each line.
            	returnContent = returnContent + inputLine;
            }
            in.close(); 
 
        } catch (Exception e) {
        	return null;
        }
        return returnContent;
	}
}
