import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Scrapper {

	public static void main(String[] args){
		// Run to scrap all the anime database
		//runScrapper();
		
		// Create genre folder and set all anime by genre.
		//getGenre();
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
}