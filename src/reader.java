 
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class reader {
	protected void readJSON(String nameFile){
        JSONParser parser = new JSONParser();
        try {
 
            Object obj = parser.parse(new FileReader(
            		nameFile));
 
            JSONObject jsonObject = (JSONObject) obj;
            writer file = new writer();
            JSONArray genre = (JSONArray) jsonObject.get("genres");
            int counter=0;
            while (!genre.isEmpty()) {
            	System.out.println("Filename: " + nameFile);
            	String type = genre.get(counter).toString();
            	String genreType = type.substring(type.indexOf(":")+2, type.indexOf("}")-1);
            	// Create directory if it does not exist.
            	checkDir("genre/"+genreType);
            	// Write the data to the file in the genre folder.
            	String fileNumber = nameFile.replaceAll("animeDatabase/", "");
            	file.write(Integer.parseInt(fileNumber.replaceAll(".json", "")), "genre/"+genreType, jsonObject.toString());
            	genre.remove(counter);
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	private void checkDir(String genre){
		File theDir = new File(genre);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    try{
		        theDir.mkdir();
		    }
		    catch(SecurityException se){
		        //handle it
		    }        
		}
	}
}
