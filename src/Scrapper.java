import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.json.simple.parser.ParseException;

public class Scrapper {

	public static void main(String[] args){
		// Get All Anime Data in Json format
		runScrapper();
		
		// Sort all anime from database into sub genre folders.
		getGenre();
		
		// Get all the images for the anime from database to local folder.
		getImages();
	}
	
	private static void runScrapper(){
		Scrap anime = new Scrap();
		int id = 1;
		while (true){
			String content = anime.getContent(id);
			if (content == null){
				System.err.println(id);
				id++;
			}
			else{
			System.out.println(id);
			PrintWriter writer;
				try {
					writer = new PrintWriter("animeDatabase/" + id + ".json", "UTF-8");
					writer.println(content);
					writer.close();
					id++;
				} catch (FileNotFoundException | UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void getGenre(){
		reader readFile = new reader();
		int counter=1;
		while (counter <= 12649){
			try{
				readFile.readJSON("animeDatabase/" + counter + ".json");
				counter++;
			} catch (Exception e){
				counter++;
			}
		}
	}
	
	private static void getImages(){
		ImageScrapper img = new ImageScrapper();
		try {
			img.getImage();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}