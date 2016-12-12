import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ImageScrapper {
	protected void getImage() throws FileNotFoundException, IOException, ParseException{
		File[] files = new File("animeDatabase/").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 

		for (File file : files) {
		    if (file.isFile()) {
		    	try {
			        JSONParser parser = new JSONParser();
		            Object obj = parser.parse(new FileReader(
		            		file.toString()));
		            JSONObject jsonObject = (JSONObject) obj;
		            Object imageUrls = jsonObject.get("cover_image");
		            String fileName = file.toString().replace("animeDatabase\\", "");
		            System.out.println(fileName.replace("json", "png") + ": " + imageUrls.toString());
	
		            String imageUrl = imageUrls.toString();
		            String destinationFile = "img/" + fileName.replace("json", "png");
		            URL url = new URL(imageUrl);
		            InputStream is = url.openStream();
		            OutputStream os = new FileOutputStream(destinationFile);
	
		            byte[] b = new byte[4096];
		            int length;
	
		            while ((length = is.read(b)) != -1) {
		                os.write(b, 0, length);
		            }
	
		            is.close();
		            os.close();
			    } catch (Exception e){
			    	System.out.println("found Exception");
			    }
		    }
		}
	}
        
}
