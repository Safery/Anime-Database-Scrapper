import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class writer {
	protected void write(int id, String location, String content){
		PrintWriter writer;
		try {
			writer = new PrintWriter(location + "/" + id + ".json", "UTF-8");
			writer.println(content);
			writer.close();
			id++;
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
